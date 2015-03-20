package net.depoker.createjs.tweenjs.client;

/**
 * The Ease class provides a collection of easing functions for use with TweenJS. It does not use the standard 4 param
 * easing signature. Instead it uses a single param which indicates the current linear ratio (0 to 1) of the tween.
 * <p>Most methods on Ease can be passed directly as easing functions:</p>
 * <pre>Tween.get(target).to({x:100}, 500, Ease.linear);</pre>
 * <p>However, methods beginning with "get" will return an easing function based on parameter values:</p>
 * <pre>Tween.get(target).to({y:200}, 500, Ease.getPowIn(2.2));</pre>
 * <p>Equations derived from work by Robert Penner.</p>
 */
public enum Ease {

    BackIn(0, 0),
    BackInOut(1, 0),
    BackOut(2, 0),
    BounceIn(3, 0),
    BounceInOut(4, 0),
    BounceOut(5, 0),
    CircIn(6, 0),
    CircInOut(7, 0),
    CircOut(8, 0),
    CubicIn(9, 0),
    CubicInOut(10, 0),
    CubicOut(11, 0),
    ElasticIn(12, 0),
    ElasticInOut(13, 0),
    ElasticOut(14, 0),
    /**
     * Mimics the simple -100 to 100 easing in Flash Pro.
     * <p>Parameters:</p>
     * <ul><li>amount - A value from -1 (ease in) to 1 (ease out) indicating the strength and direction of the ease.</li></ul>
     */
    Get(15, 1),
    /**
     * Configurable "back in" ease.
     * <p>Parameters:</p>
     * <ul><li>amount - The strength of the ease.</li></ul>
     */
    GetBackIn(16, 1),
    /**
     * Configurable "back in out" ease.
     * <p>Parameters:</p>
     * <ul><li>amount - The strength of the ease.</li></ul>
     */
    GetBackInOut(17, 1),
    /**
     * Configurable "back out" ease.
     * <p>Parameters:</p>
     * <ul><li>amount - The strength of the ease.</li></ul>
     */
    GetBackOut(18, 1),
    /**
     * Configurable elastic ease.
     * <p>Parameters:</p>
     * <ul>
     *     <li>amplitude</li>
     *     <li>period </li>
     * </ul>
     */
    GetElasticIn(19, 2),
    /**
     * Configurable elastic ease.
     * <p>Parameters:</p>
     * <ul>
     *     <li>amplitude</li>
     *     <li>period </li>
     * </ul>
     */
    GetElasticInOut(20, 2),
    /**
     * Configurable elastic ease.
     * <p>Parameters:</p>
     * <ul>
     *     <li>amplitude</li>
     *     <li>period </li>
     * </ul>
     */
    GetElasticOut(21, 2),
    /**
     * Configurable exponential ease.
     * <p>Parameters:</p>
     * <ul><li>pow - The exponent to use (ex. 3 would return a cubic ease).</li></ul>
     */
    GetPowIn(22, 1),
    /**
     * Configurable exponential ease.
     * <p>Parameters:</p>
     * <ul><li>pow - The exponent to use (ex. 3 would return a cubic ease).</li></ul>
     */
    GetPowInOut(23, 1),
    /**
     * Configurable exponential ease.
     * <p>Parameters:</p>
     * <ul><li>pow - The exponent to use (ex. 3 would return a cubic ease).</li></ul>
     */
    GetPowOut(24, 1),
    Linear(25, 0),
    None(26, 0),
    QuadIn(27, 0),
    QuadInOut(28, 0),
    QuadOut(29, 0),
    QuartIn(30, 0),
    QuartInOut(31, 0),
    QuartOut(32, 0),
    QuintIn(33, 0),
    QuintInOut(34, 0),
    QuintOut(35, 0),
    SineIn(36, 0),
    SineInOut(37, 0),
    SineOut(38, 0);

    /**
     * The unique number associated with the enum/function.
     */
    public final int code;
    /**
     * The number of parameters the function requires. Any required parameters are documented with the enumeration.
     */
    public final int params;

    Ease(int code, int params) {
        this.code = code;
        this.params = params;
    }

}
