package br.com.DeybsonFrancisco.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class CreatedResourceEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1382995137083425323L;

	private HttpServletResponse response;
	private Long chave;
	private String path;

	public CreatedResourceEvent(Object source, HttpServletResponse response, Long chave, String path) {
		super(source);
		this.response = response;
		this.chave = chave;
		this.path = path;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Long getChave() {
		return chave;
	}

	public String getPath() {
		return path;
	}
	
	
}