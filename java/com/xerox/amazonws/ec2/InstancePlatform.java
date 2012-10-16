//
// maragogype - A client library for Amazon Web Services
// Copyright (C) 2010 JetBrains Inc
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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author Eugene Petrenko (eugene.petrenko@gmail.com)
 *         Date: 08.03.11 18:22
 */
public enum InstancePlatform {
  i386(Collections.singleton(Platform.i386)),
  x86_64(Collections.singleton(Platform.x86_64)),

  ANY(Arrays.asList(Platform.i386, Platform.x86_64))
  ;

  private final Collection<Platform> supportedPlatforms;

  InstancePlatform(Collection<Platform> supportedPlatforms) {
    this.supportedPlatforms = supportedPlatforms;
  }

  public boolean supportPlatform(Platform pf) {
    return supportedPlatforms.contains(pf);
  }
}
