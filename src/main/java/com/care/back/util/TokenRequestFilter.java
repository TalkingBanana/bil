package com.care.back.util;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.care.back.member.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class TokenRequestFilter extends OncePerRequestFilter {
    private final MemberService memberService;
    private final JwtUtil jwtUtil;
    
	@Override
	protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request,
			jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain)
			throws jakarta.servlet.ServletException, IOException {
		try {
			if ("/user/login".equals(request.getRequestURI())) {
				doFilter(request, response, filterChain);
			} else if ("/user/register".equals(request.getRequestURI())) {
				doFilter(request, response, filterChain);
			} else {
				String token = parseJwt(request);
				if (token == null) {
					response.sendError(403);
				} else {
					DecodedJWT tokenInfo = jwtUtil.decodeToken(token);
					if (tokenInfo != null) {
						String id = tokenInfo.getClaim("id").asString();
						UserDetails loginUser = memberService.loadUserByUsername(id);
						UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
						authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
						
						SecurityContextHolder.getContext().setAuthentication(authentication);
						doFilter(request, response, filterChain);
					} else {
						log.error("### TokenInfo is Null");
					}
				}
			}
		} catch (Exception e) {
			log.error("### Filter Exception{}", e.getMessage());
		}
	}
	
	private String parseJwt(HttpServletRequest request) {
		String headerAuth = request.getHeader("authorization");
		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }
        return null;
	}
}