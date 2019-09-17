package com.altimetrik.git;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

public class RetrievePOU {

	// static List<UserPouBO> userPOUList= new ArrayList<>();
	static UserPouBO userPouBO;

	public static void main(String args[]) {
		List<UserPouBO> userPOUList = populateUserPOUBO();
		Set<UserPOUPK> set = new HashSet<UserPOUPK>();
		userPOUList.sort(Comparator.comparing(UserPouBO::getPouTimeStamp).reversed());

		for (UserPouBO userPou : userPOUList) {
			if (!Arrays.asList(new String[] { "D", "R", "S" }).contains(userPou.getPouStatus())
					&& (!set.contains(new UserPOUPK(userPou.getAppId(), userPou.getLlid(), userPou.getPouId(), userPou.getCountry(), userPou.getLlNameCode())))) {

				System.out.println(userPou);
			} else {
				set.add(new UserPOUPK(userPou.getAppId(), userPou.getLlid(), userPou.getPouId(), userPou.getCountry(), userPou.getLlNameCode()));
			}

		}

		// System.out.println(userPOUList);
	}

	static List<UserPouBO> populateUserPOUBO() {
		List<UserPouBO> userPOUList = new ArrayList<>();
		Calendar c = Calendar.getInstance();
		c.set(2019, 7, 1);
		userPouBO = new UserPouBO(100504F, "LLID1", "1001", "NZL", "1033", c.getTime(), "1", "First");
		userPOUList.add(userPouBO);
		userPouBO = new UserPouBO(100504F, "LLID1", "1002", "NZL", "1033", c.getTime(), "1", "Second");
		userPOUList.add(userPouBO);
		userPouBO = new UserPouBO(100504F, "LLID2", "1001", "NZL", "1032", c.getTime(), "1", "Third");
		userPOUList.add(userPouBO);
		c.set(2019, 7, 2);
		userPouBO = new UserPouBO(100504F, "LLID1", "1001", "NZL", "1033", c.getTime(), "D", "Fourth");
		userPOUList.add(userPouBO);
		return userPOUList;
	}

}

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
class UserPOUPK {
	private Float appId;
	private String llid;
	private String pouId;
	private String country;
	private String llNameCode;

}