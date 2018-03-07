package framework.Tests;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainFinal {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ProcessBuilder builder = new ProcessBuilder("cmd.exe","/c","cd \"C:\\Users\\RTR\\git\\QualityMindsWebTest\\QualityMindsWeb\" && mvn test");
		builder.redirectErrorStream(true);
		Process p = builder.start();
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
	String line;
		while (true) {
		line = r.readLine();
	if (line == null) {
	break;
	}
		System.out.println(line);
		}

		}
	}


