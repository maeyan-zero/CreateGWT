package net.depoker.createjs.easeljs.client.helper;

public enum DisplayProp
{
	X("x"),
	Y("y"),
	REGX("regX"),
	REGY("regY"),
	ALPHA("alpha"),
	VISIBLE("visible"),
	ROTATION("rotation");

	final String property;

	DisplayProp(String str) { this.property = str; }

	@Override
	public String toString() { return property; }
}
