package orm;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataBasesBuilder {
	
	private static SqlSessionFactory factorty;
	private static final String CONGIF = "orm/mybatisConfig.xml";
	
	static {
		try {
			factorty = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsReader(CONGIF));
					
	}
		catch(Exception e) {
		e.printStackTrace();
	}
	
}
		
		
		
	public static SqlSessionFactory getFactory() {
		return factorty;

	}	
}