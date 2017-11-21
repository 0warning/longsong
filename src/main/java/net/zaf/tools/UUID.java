package net.zaf.tools;

public class UUID {

	public static String uuid() {
		java.util.UUID uuid = java.util.UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
}
