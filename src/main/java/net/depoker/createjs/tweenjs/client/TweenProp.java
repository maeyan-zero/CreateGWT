package net.depoker.createjs.tweenjs.client;

public enum TweenProp
{
	OVERRIDE("override");

	final String property;

	TweenProp(String str) { this.property = str; }

	@Override
	public String toString() { return property; }
}
