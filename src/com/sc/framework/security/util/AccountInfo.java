package com.sc.framework.security.util;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.sc.system.pojo.UserRoleMenu;

/**
 * 账户信息
 * 实例进入Session中的对象
 * 
 */
public class AccountInfo extends User {

	private static final long serialVersionUID = -8782947846459151398L;

	private Long accountId;
	private String accountCode;
	private String userName;
	private Long userId;
	private String orgCode;
	private String orgType;
	private String zongdCode;
	private String orgName;
	private String userImg;
	private String jgCode;
	private Date  dqDate;
	
	//private List<UserRoleMenu> topMenu;
	//private List<UserRoleMenu> leftMenu;
	
	private Map<String,UserRoleMenu> topMenu;
	
	private Map<String,List<UserRoleMenu>> leftMenu;
	

	public AccountInfo(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
		topMenu = new LinkedHashMap<String,UserRoleMenu>();
		leftMenu = new LinkedHashMap<String,List<UserRoleMenu>>();
	}

	public boolean equals(Object object) {
		if (object instanceof AccountInfo) {
			if (this.accountId.toString().equals(
					((AccountInfo) object).accountId.toString()))
				return true;
		}
		return false;
	}

	public int hashCode() {
		return this.accountId.hashCode();
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public Map<String, UserRoleMenu> getTopMenu() {
		return topMenu;
	}

	public void setTopMenu(Map<String, UserRoleMenu> topMenu) {
		this.topMenu = topMenu;
	}

	public Map<String, List<UserRoleMenu>> getLeftMenu() {
		return leftMenu;
	}

	public void setLeftMenu(Map<String, List<UserRoleMenu>> leftMenu) {
		this.leftMenu = leftMenu;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getZongdCode() {
		return zongdCode;
	}

	public void setZongdCode(String zongdCode) {
		this.zongdCode = zongdCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public String getJgCode() {
		return jgCode;
	}

	public void setJgCode(String jgCode) {
		this.jgCode = jgCode;
	}

	public Date getDqDate() {
		return dqDate;
	}

	public void setDqDate(Date dqDate) {
		this.dqDate = dqDate;
	}
	
}
