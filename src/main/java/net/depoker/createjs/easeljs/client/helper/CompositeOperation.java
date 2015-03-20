package net.depoker.createjs.easeljs.client.helper;

public enum CompositeOperation
{
	SOURCE_ATOP,
	SOURCE_IN,
	SOURCE_OUT,
	SOURCE_OVER,
	DESTINATION_ATOP,
	DESTINATION_IN,
	DESTINATION_OUT,
	DESTINATION_OVER,
	LIGHTER,
	COPY,
	XOR;

	@Override
	public String toString()
	{
		return this.name().toLowerCase().replace("_", "-");
	}

	public static CompositeOperation fromString(String str)
	{
		for (CompositeOperation composite : values())
		{
			if (composite.toString().toLowerCase().replace("_", "-").equals(str))
			{
				return composite;
			}
		}
		return null;
	}
}
