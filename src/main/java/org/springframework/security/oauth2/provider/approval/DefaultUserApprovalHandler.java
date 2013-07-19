/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.security.oauth2.provider.approval;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.AuthorizationRequest;

/**
 * A default user approval handler that doesn't remember any decisions.
 * 
 * @author Dave Syer
 * 
 */
public class DefaultUserApprovalHandler implements UserApprovalHandler {

	private String approvalParameter = AuthorizationRequest.USER_OAUTH_APPROVAL;
	
	/**
	 * @param approvalParameter the approvalParameter to set
	 */
	public void setApprovalParameter(String approvalParameter) {
		this.approvalParameter = approvalParameter;
	}
	
	public AuthorizationRequest updateBeforeApproval(AuthorizationRequest authorizationRequest, Authentication userAuthentication) {
		return authorizationRequest;
	}

	/**
	 * Basic implementation just requires the authorization request to be explicitly approved and the user to be
	 * authenticated.
	 * 
	 * @param authorizationRequest The authorization request.
	 * @param userAuthentication the current user authentication
	 * 
	 * @return Whether the specified request has been approved by the current user.
	 */
	public boolean isApproved(AuthorizationRequest authorizationRequest, Authentication userAuthentication) {
		String flag = authorizationRequest.getApprovalParameters().get(approvalParameter);
		boolean approved = flag != null && flag.toLowerCase().equals("true");
		return userAuthentication.isAuthenticated() && approved;
	}

}
