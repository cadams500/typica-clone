//
// typica - A client library for Amazon Web Services
// Copyright (C) 2008 Xerox Corporation
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

import org.apache.commons.codec.binary.Base64;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * A launch configuration encapsulates the parameters used for launching an AMI
 *
 * @author Moritz Post <mpost@innoopract.com>
 */
public class LaunchConfiguration {
  /**
   * A name given to this launch config
   */
  private String configName;

  /**
   * The ID of the AMI to launch.
   */
  private String imageId;

  /**
   * The minimum number of AMIs to launch.
   */
  private int minCount;

  /**
   * The maximum (desired) number of AMIs to launch.
   */
  private int maxCount;

  /**
   * The name of the key file to access the AMI via ssh.
   */
  private String keyName;

  /**
   * The security group to launch the AMI in.
   */
  private List<String> securityGroup;

  /**
   * The security group ids to launch the AMI in.
   */
  private List<String> securityGroupIds;

  /**
   * The availability AvailabilityZone to launch the AMI in.
   */
  private String availabilityZone;

  /**
   * Custom User Data to init the AMI with.
   */
  private byte[] userData;

  /**
   * The size of the hardware to launch the AMI in.
   */
  private InstanceType instanceType = InstanceType.DEFAULT;

  /**
   * The id of the kernel to use.
   */
  private String kernelId;

  /**
   * The ramdisk to use.
   */
  private String ramdiskId;

  /**
   * The block device mapping to use.
   */
  private List<BlockDeviceMapping> blockDeviceMappings;

  private boolean monitoring;

  private boolean addressingType = true;

  private String additionalInfo;

  /**
   * The subnet to be used with Amazon VPC
   */
  private String subnetId;

  /**
   * The private IP to be used with Amazon VPC
   */
  private String privateIpAddress;

  /**
   * placement group for cluster compute instances
   */
  private String groupName;

  private String clientToken;

  /**
   * Determines whether the instance stops or terminates on instance-initiated shutdown.*
   */
  private InstanceShutdownBehavior instanceShutdownBehaviour = null;

  /**
   * Launches the given AMI one time. The min and max values are '1'.
   *
   * @param imageId the AMI to launch
   */
  public LaunchConfiguration(final String imageId) {
    this(imageId, 1, 1);
  }

  /**
   * The launch parameter with the minimum required number of parameter.
   *
   * @param imageId  the id of the AMI to launch
   * @param minCount the minimum required number of instances
   * @param maxCount the maximum number of AMIs desired
   */
  public LaunchConfiguration(final String imageId, final int minCount, final int maxCount) {
    this.imageId = imageId;
    this.minCount = minCount;
    this.maxCount = maxCount;
  }

  /**
   * The launch parameter with the name being supplied.
   *
   * @param configName the name given to this launch config
   * @param imageId    the id of the AMI to launch
   * @param minCount   the minimum required number of instances
   * @param maxCount   the maximum number of AMIs desired
   */
  public LaunchConfiguration(final String configName, final String imageId, final int minCount, final int maxCount) {
    this.configName = configName;
    this.imageId = imageId;
    this.minCount = minCount;
    this.maxCount = maxCount;
  }

  /**
   * @return the configName
   */
  public String getConfigName() {
    return this.configName;
  }

  /**
   * @param configName the configName to set
   */
  public void setConfigName(final String configName) {
    this.configName = configName;
  }

  /**
   * @return the imageId
   */
  public String getImageId() {
    return this.imageId;
  }

  /**
   * @param imageId the imageId to set
   */
  public void setImageId(final String imageId) {
    this.imageId = imageId;
  }

  /**
   * @return the minCount
   */
  public int getMinCount() {
    return this.minCount;
  }

  /**
   * @param minCount the minCount to set
   */
  public void setMinCount(final int minCount) {
    this.minCount = minCount;
  }

  /**
   * @return the maxCount
   */
  public int getMaxCount() {
    return this.maxCount;
  }

  /**
   * @param maxCount the maxCount to set
   */
  public void setMaxCount(final int maxCount) {
    this.maxCount = maxCount;
  }

  /**
   * @return the keyName
   */
  public String getKeyName() {
    return this.keyName;
  }

  /**
   * @param keyName the keyName to set
   */
  public void setKeyName(final String keyName) {
    this.keyName = keyName;
  }

  /**
   * @return the securityGroup
   */
  @Nullable
  public List<String> getSecurityGroup() {
    return this.securityGroup;
  }

  /**
   * @return the securityGroupIds
   */
  @Nullable
  public List<String> getSecurityGroupIds() {
    return this.securityGroupIds;
  }

  /**
   * @param securityGroup the securityGroup to set
   */
  public void setSecurityGroup(final List<String> securityGroup) {
    this.securityGroup = securityGroup;
  }

  /**
   * @param securityGroupIds the securityGroup to set
   */
  public void setSecurityGroupIds(final List<String> securityGroupIds) {
    this.securityGroupIds = securityGroupIds;
  }

  /**
   * @return the AvailabilityZone
   */
  public String getAvailabilityZone() {
    return this.availabilityZone;
  }

  /**
   * @param availabilityZone the AvailabilityZone to set
   */
  public void setAvailabilityZone(final String availabilityZone) {
    this.availabilityZone = availabilityZone;
  }

  /**
   * @return the instanceType
   */
  public InstanceType getInstanceType() {
    return this.instanceType;
  }

  /**
   * @param instanceType the instanceType to set
   */
  public void setInstanceType(final InstanceType instanceType) {
    this.instanceType = instanceType;
  }

  /**
   * @return the userData
   */
  public byte[] getUserData() {
    return this.userData;
  }

  /**
   * @param userData the userData to set
   */
  public void setUserData(final byte[] userData) {
    this.userData = userData;
  }

  /**
   * @return the additionalInfo
   */
  public String getAdditionalInfo() {
    return this.additionalInfo;
  }

  /**
   * @param additionalInfo the additionalInfo to set
   */
  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  /**
   * @return the kernelId
   */
  public String getKernelId() {
    return this.kernelId;
  }

  /**
   * @param kernelId the kernelId to set
   */
  public void setKernelId(String kernelId) {
    this.kernelId = kernelId;
  }

  /**
   * @return the ramdiskId
   */
  public String getRamdiskId() {
    return this.ramdiskId;
  }

  /**
   * @param ramdiskId the ramdiskId to set
   */
  public void setRamdiskId(String ramdiskId) {
    this.ramdiskId = ramdiskId;
  }

  /**
   * @return the blockDeviceMappings
   */
  public List<BlockDeviceMapping> getBlockDevicemappings() {
    return this.blockDeviceMappings;
  }

  /**
   * @param blockDeviceMappings the blockDeviceMappings to set
   */
  public void setBlockDevicemappings(List<BlockDeviceMapping> blockDeviceMappings) {
    this.blockDeviceMappings = blockDeviceMappings;
  }

  /**
   * @return state of instance monitoring
   */
  public Boolean isMonitoring() {
    return monitoring;
  }

  /**
   * @param set sets the state of instance monitoring
   */
  public void setMonitoring(boolean set) {
    monitoring = set;
  }

  /**
   * @return if addressing is set to public
   */
  public Boolean isPublicAddressing() {
    return addressingType;
  }

  /**
   * @return the subnetId
   */
  public String getSubnetId() {
    return this.subnetId;
  }

  /**
   * @param subnetId the subnetId to set
   */
  public void setSubnetId(String subnetId) {
    this.subnetId = subnetId;
  }

  /**
   * @return the privateIpAddress
   */
  public String getPrivateIpAddress() {
    return this.privateIpAddress;
  }

  /**
   * @param privateIpAddress the privateIpAddress to set
   */
  public void setPrivateIpAddress(String privateIpAddress) {
    this.privateIpAddress = privateIpAddress;
  }

  /**
   * @return the groupName used with cluster compute instances
   */
  public String getGroupName() {
    return this.groupName;
  }

  /**
   * @param groupName the groupName to set
   */
  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }


  /**
   * @return Idempotency token you provided when you launched the instance.
   */
  @Nullable
  public String getClientToken() {
    return clientToken;
  }


  /**
   * Sets idempotency token you provided when you launched the instance.
   */
  public void setClientToken(@Nullable String clientToken) {
    this.clientToken = clientToken;
  }

  /**
   * Determines whether the instance stops or terminates on instance-initiated shutdown.
   *
   * @return behaviour
   */
  @Nullable
  public InstanceShutdownBehavior getInstanceShutdownBehaviour() {
    return instanceShutdownBehaviour;
  }

  /**
   * Determines whether the instance stops or terminates on instance-initiated shutdown.
   *
   * @param instanceShutdownBehaviour behaviour
   */
  public void setInstanceShutdownBehaviour(@Nullable InstanceShutdownBehavior instanceShutdownBehaviour) {
    this.instanceShutdownBehaviour = instanceShutdownBehaviour;
  }

  /**
   * For some eucaluptus clusters, need to set this false (=private)
   *
   * @param set sets the public addressing mode (true by default)
   */
  public void setPublicAddressing(boolean set) {
    addressingType = set;
  }

  void prepareQueryParams(String prefix, boolean setMinAndMax, Map<String, String> params) {
    params.put(prefix + "ImageId", getImageId());
    if (setMinAndMax) {
      params.put(prefix + "MinCount", "" + getMinCount());
      params.put(prefix + "MaxCount", "" + getMaxCount());
    }

    byte[] userData = getUserData();
    if (userData != null && userData.length > 0) {
      params.put(prefix + "UserData", new String(Base64.encodeBase64(userData)));
    }
    params.put(prefix + "AddressingType", isPublicAddressing() ? "public" : "private");
    String keyName = getKeyName();
    if (isNotEmpty(keyName)) {
      params.put(prefix + "KeyName", keyName);
    }

    final List<String> groups = getSecurityGroup();
    if (groups != null) {
      for (int i = 0; i < groups.size(); i++) {
        params.put(prefix + "SecurityGroup." + (i + 1), groups.get(i));
      }
    }
    final List<String> groupIds = getSecurityGroup();
    if (groupIds != null) {
      for (int i = 0; i < groupIds.size(); i++) {
        params.put(prefix + "SecurityGroupId." + (i + 1), groupIds.get(i));
      }
    }
    if (isNotEmpty(getAdditionalInfo())) {
      params.put(prefix + "AdditionalInfo", getAdditionalInfo());
    }
    params.put(prefix + "InstanceType", getInstanceType().getTypeId());
    if (isNotEmpty(getAvailabilityZone())) {
      params.put(prefix + "Placement.AvailabilityZone", getAvailabilityZone());
    }
    if (isNotEmpty(getKernelId())) {
      params.put(prefix + "KernelId", getKernelId());
    }
    if (isNotEmpty(getRamdiskId())) {
      params.put(prefix + "RamdiskId", getRamdiskId());
    }
    if (blockDeviceMappings != null) {
      for (int i = 0; i < blockDeviceMappings.size(); i++) {
        BlockDeviceMapping bdm = blockDeviceMappings.get(i);
        params.put("BlockDeviceMapping." + (i + 1) + ".DeviceName", bdm.getDeviceName());
        if (bdm.getVirtualName() != null) {
          params.put("BlockDeviceMapping." + (i + 1) + ".VirtualName", bdm.getVirtualName());
        } else {
          if (bdm.getSnapshotId() != null) {
            params.put("BlockDeviceMapping." + (i + 1) + ".Ebs.SnapshotId", bdm.getSnapshotId());
          }
          if (bdm.getVolumeSize() > 0) {
            params.put("BlockDeviceMapping." + (i + 1) + ".Ebs.VolumeSize", "" + bdm.getVolumeSize());
          }
          params.put("BlockDeviceMapping." + (i + 1) + ".Ebs.DeleteOnTermination", bdm.isDeleteOnTerminate() ? "true" : "false");
        }
      }
    }
    if (isMonitoring()) {
      params.put(prefix + "Monitoring.Enabled", "true");
    }

    final String subnetId = getSubnetId();
    if (isNotEmpty(subnetId)) {
      params.put(prefix + "SubnetId", subnetId);
    }

    final String privateIpAddress = getPrivateIpAddress();
    if (isNotEmpty(privateIpAddress)) {
      params.put(prefix + "PrivateIpAddress", privateIpAddress);
    }

    final String groupName = getGroupName();
    if (isNotEmpty(groupName)) {
      params.put(prefix + "GroupName", groupName);
    }

    final String tok = getClientToken();
    if (isNotEmpty(tok)) {
      params.put("clientToken", tok);
    }

    final InstanceShutdownBehavior beh = getInstanceShutdownBehaviour();
    if (beh != null) {
      switch (beh) {
        case STOP:
          params.put("InstanceInitiatedShutdownBehavior", "stop");
          break;
        case TERMINATE:
          params.put("InstanceInitiatedShutdownBehavior", "terminate");
          break;
        default:
          throw new IllegalArgumentException("Unexpected value of InstanceShutdownBehavior: " + beh);
      }
    }
  }

  private static boolean isNotEmpty(@Nullable String tok) {
    return tok != null && !tok.trim().equals("");
  }
}
