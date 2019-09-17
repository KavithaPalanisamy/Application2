package com.altimetrik.git;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPouBO implements Serializable {
	private static final long serialVersionUID = 3478472742461902511L;
	private Float appId;
	private String llid;
	private String pouId;
	private String country;
	private String llNameCode;
	private Date pouTimeStamp;
	private String pouStatus;
	private String pouDesc;
}
