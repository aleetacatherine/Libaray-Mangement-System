package Library.spring.entities;

import java.io.Serializable;
import java.util.Objects;

public class BookIssueId implements Serializable {
	
	 private int id;
	 private int memberId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, memberId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookIssueId other = (BookIssueId) obj;
		return id == other.id && memberId == other.memberId;
	}
	@Override
	public String toString() {
		return "BookIssueId [id=" + id + ", memberId=" + memberId + "]";
	}
	
	    
	 
}
