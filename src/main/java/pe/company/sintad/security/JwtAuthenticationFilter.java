package pe.company.sintad.security;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.company.sintad.service.UserDetailsServiceImpl;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        
    	//incia el proceso de validacion extrallendo el token del header
    	String requestTokenHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;

        //se usa "Bearer " que es igual a 7 espacios para realizar la localizaciond el token en el header
        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){
            jwtToken = requestTokenHeader.substring(7);

            try{
            	
            	//Se extrae el nombre de usuario
                username = this.jwtUtil.extractUsername(jwtToken);
                
            }catch (ExpiredJwtException exception){
            	
                System.out.println("El token ha expirado");
                
            }catch (Exception e){
            	
                e.printStackTrace();
            }

        }else{
        	
            System.out.println("Token invalido , no empieza con bearer string");
            
        }

        //se encarga de verificar si el nombre de usuario obtenido del token JWT
        //Si ambas condiciones se cumplen, significa que el usuario no está autenticado actualmente y que el token JWT es válido
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
        	
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            
            if(this.jwtUtil.validateToken(jwtToken,userDetails)){
            	
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }else{
            System.out.println("El token no es valido" + jwtToken);
        }
        filterChain.doFilter(request,response);
    }
}
