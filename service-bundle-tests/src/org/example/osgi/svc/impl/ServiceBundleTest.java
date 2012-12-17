/*
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
package org.example.osgi.svc.impl;

import org.example.osgi.svc.ServiceOne;
import org.junit.Assert;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class ServiceBundleTest {
	@Test
	public void testServiceRegistration() {
		// The test is in the same package as the bundle, access package-private member
		BundleContext ctx = Activator.bundleContext;

		// Check that the service has been registered
		ServiceReference ref = ctx.getServiceReference(ServiceOne.class.getName());
		ServiceOne svc = ctx.getService(ref);

		Assert.assertEquals("This service implementation should reverse the input",
		        "4321", svc.myOperation("1234"));

		Assert.assertTrue(svc instanceof ServiceOneImpl);
	}
}
