package main.view;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class BuildedSqlMapConfig {
	private static BuildedSqlMapConfig sqlConfig = new BuildedSqlMapConfig();
	private static SqlMapClient smc;

	public static SqlMapClient getInstance() {
		return smc;
	}

	static {
		Charset charset = Charset.forName("UTF-8");
		Resources.setCharset(charset);
		Reader rd;
		try {
			rd = Resources.getResourceAsReader("sqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
