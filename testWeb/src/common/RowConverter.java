package common;

import java.sql.ResultSet;

public interface RowConverter<T> {
	
	public T convert(ResultSet rs);

}
