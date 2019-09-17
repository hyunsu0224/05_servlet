package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * 서블릿 서비스에 진입하는 요청에 대해서
 * 요청객체, 응답객체에 한글 설정을 하는 인코딩 필터 클래스
 * 
 * web.xml 에 <filter> 로 등록하거나
 * =====================================================
 * @WebFilter 에노테이션으로 등록해서 사용 annotation
 * 	- filterName = encodingFilter
 * 
 * 	두 개의 초기화 파라미터를 넘겨서 필터 초기화
 *  charEncoding : utf-8
 *  contentType : text/html; charset=utf-8
 *  
 *  필터가 작동할 주소 형태 등록
 *  - urlPatterns : /* (모든 주소)
 *  				==> 이 서비스(웹 어플리케이션) 의
 *  				==> 컨텍스트 패스 이하로 들어오는 모든 요청 주소에 대해서
 *  				==> 이 필터가 작동한다.  
 */
@WebFilter(filterName = "encodingFilter"
		  ,initParams = {@WebInitParam(name="charEncoding", value = "utf-8")
		  				,@WebInitParam(name="contentType", value = "text/html; charset=utf-8")}
		  ,urlPatterns = {"/*"} )
public class EncodingFilter implements Filter {

	// 이 필터가 사용할 필터 설정값을 저장하는 멤버 변수
	private FilterConfig config;
	
	/**
	 * 필터의 초기화를 담당하는 메소드
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = config;
		/*	=================================================================
		 * 	필터의 init() 메소드는 웹 컨테이너(톰캣)에 의해
		 * 	필터 초기화시에 자동으로 작동되는 필터 라이프 사이클 메소드
		 * 	
		 * 	init() 이 호출될 때, 웹 컨테이너(톰캣, 서블릿 컨테이너)는
		 * 	web.xml 에 <filter> 로 설정된 내용 
		 *  혹은 @WebFilter 로 설정된 내용을 읽어서
		 *  이 메소드 매개변수로 전달한다.
		 *  
		 *  이렇게 전달된 필터 설정 값을 변수로 저장하여 사용한다.
		 *  ===================================================================
		 */
	}
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
	
    /**
     * 
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	



}
