package com.sap.cloud.security.xsuaa.client;

import java.net.URI;

import org.springframework.util.Assert;
import org.springframework.web.util.UriComponentsBuilder;

public class XsuaaDefaultEndpoints implements OAuth2ServiceEndpointsProvider {
	private final URI baseUri;
	private static final String TOKEN_ENDPOINT = "/oauth/token";
	private static final String AUTHORIZE_ENDPOINT = "/oauth/authorize";
	private static final String KEYSET_ENDPOINT = "/token_keys";

	/**
	 * Creates a new XsuaaRestClient.
	 *
	 * @param baseUri
	 *            - the base URI of XSUAA. Based on the base URI the tokenEndpoint,
	 *            authorize and key set URI (JWKS) will be derived.
	 */
	public XsuaaDefaultEndpoints(URI baseUri) {
		Assert.notNull(baseUri, "XSUAA base URI must not be null.");
		this.baseUri = baseUri;
	}

	/**
	 * Creates a new XsuaaRestClient.
	 *
	 * @param baseUri
	 *            - the base URI of XSUAA. Based on the base URI the tokenEndpoint,
	 *            authorize and key set URI (JWKS) will be derived.
	 */
	public XsuaaDefaultEndpoints(String baseUri) {
		this(URI.create(baseUri));
	}

	@Override
	public URI getTokenEndpoint() {
		return UriComponentsBuilder.fromUri(baseUri).path(TOKEN_ENDPOINT).build().toUri();
	}

	@Override
	public URI getAuthorizeEndpoint() {
		return UriComponentsBuilder.fromUri(baseUri).path(AUTHORIZE_ENDPOINT).build().toUri();
	}

	@Override
	public URI getJwksUri() {
		return UriComponentsBuilder.fromUri(baseUri).path(KEYSET_ENDPOINT).build().toUri();
	}

}