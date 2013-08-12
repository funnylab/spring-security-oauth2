/*
 * Cloud Foundry 2012.02.03 Beta
 * Copyright (c) [2009-2012] VMware, Inc. All Rights Reserved.
 *
 * This product is licensed to you under the Apache License, Version 2.0 (the "License").
 * You may not use this product except in compliance with the License.
 *
 * This product includes a number of subcomponents with
 * separate copyright notices and license terms. Your use of these
 * subcomponents is subject to the terms and conditions of the
 * subcomponent's license, as noted in the LICENSE file.
 */

package org.springframework.security.oauth2.provider;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

/**
 * Factory for tests to create OAuth2Request objects.
 * 
 * @author Dave Syer
 * 
 */
public class RequestTokenFactory {

	public static OAuth2Request createOAuth2Request(Map<String, String> requestParameters, String clientId,
			Collection<? extends GrantedAuthority> authorities, boolean approved, Set<String> scope,
			Set<String> resourceIds, String redirectUri, Map<String, Serializable> extensionProperties) {
		return new OAuth2Request(requestParameters, clientId, authorities, approved, scope, resourceIds, redirectUri,
				extensionProperties);
	}

}
