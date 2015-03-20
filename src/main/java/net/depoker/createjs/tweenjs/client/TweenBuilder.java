package net.depoker.createjs.tweenjs.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsonUtils;

public class TweenBuilder
{
	final private StringBuilder stringBuilder = new StringBuilder();

	protected TweenBuilder()
	{
		stringBuilder.append("{");
	}

	public static TweenBuilder get() { return new TweenBuilder(); }

	public TweenBuilder build(String property, int value) { return build(property, String.valueOf(value)); }
	public TweenBuilder build(String property, double value) { return build(property, String.valueOf(value)); }
	public TweenBuilder build(String property, boolean value) { return build(property, String.valueOf(value)); }
	public TweenBuilder build(Enum property, int value) { return build(property.toString(), String.valueOf(value)); }
	public TweenBuilder build(Enum property, double value) { return build(property.toString(), String.valueOf(value)); }
	public TweenBuilder build(Enum property, boolean value) { return build(property.toString(), String.valueOf(value)); }

	public TweenBuilder build(String property, String value)
	{
		if (stringBuilder.length() > 1) stringBuilder.append(",");
		stringBuilder.append(property);
		stringBuilder.append(":");
		stringBuilder.append(value);
		return this;
	}

	public String toString() { return stringBuilder.append("}").toString(); }
	public JavaScriptObject toJso() { return JsonUtils.unsafeEval(toString()); }
}
