//
// typica - A client library for Amazon Web Services
// Copyright (C) 2007,2008 Xerox Corporation
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package com.xerox.amazonws.ec2;

/**
 * This is a container class for an load balancer listener
 */
public class Listener {
	private String protocol;
	private int loadBalancerPort;
	private int instancePort;

	public Listener(String protocol, int loadBalancerPort,
					int instancePort) {
		this.protocol = protocol;
		this.loadBalancerPort = loadBalancerPort;
		this.instancePort = instancePort;
	}

	public String getProtocol() {
		return protocol;
	}

	public int getLoadBalancerPort() {
		return loadBalancerPort;
	}

	public int getInstancePort() {
		return instancePort;
	}

	public String toString() {
		return "Listener[protocol=" + protocol + ", lbPort=" + loadBalancerPort + 
				", instancePort=" + instancePort + "]";
	}
}
