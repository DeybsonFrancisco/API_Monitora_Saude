package br.com.DeybsonFrancisco.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.DeybsonFrancisco.event.CreatedResourceEvent;

@Component
public class CreatedResourceListener implements ApplicationListener<CreatedResourceEvent> {

	@Override
	public void onApplicationEvent(CreatedResourceEvent event) {
		HttpServletResponse response = event.getResponse();
		Long chave = event.getChave();
		String path = event.getPath();

		addHeaderLocation(response, chave, path);
	}

	private void addHeaderLocation(HttpServletResponse response, Long chave, String path) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path(String.format("/{%s}", path))
				.buildAndExpand(chave).toUri();
		response.setHeader("Location", uri.toASCIIString());
	}

}
