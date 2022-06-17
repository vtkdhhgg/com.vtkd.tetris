package entities;

import listener.ShapeListener;
import util.Global;

import java.awt.*;
import java.security.ProtectionDomain;

/**
 * 维护一个图形, 一个图形可以有一种或多种状态
 *
 * 可以通过 setColor() 方法改变图形的颜色
 *
 * 可以通过覆盖 drawUnit(Graphics, int, int, int, int) 方法 改变图形的显示
 *
 * 用内部类 ShapeDriver 驱动图形定时向下移动
 *
 * 使用时一定要给实例注册监听器, 否则不能正常运行
 *
 * @version 1.0 2022-6-17
 *
 * @author vtkd
 *
 */
public class Shape {

    /**
     * 变形(旋转)
     */
    public static final int ROTATE = 5;

    /**
     * 上移
     */
    public static final int UP = 1;
    /**
     * 下落
     */
    public static final int DOWN = 2;
    /**
     * 左移
     */
    public static final int LEFT = 3;
    /**
     * 右移
     */
    public static final int RIGHT = 4;
    /**
     * 监听器组
     */
    protected ShapeListener listener;

    /**
     * todo 写好注释
     */
    protected int[][] body;

    /**
     * 当前显示的状态
     */
    protected int status;

    /**
     * 图形的真实高度
     */
    protected int height;

    /**
     * 左上角的位置
     */
    protected int left;

    /**
     * 下落的速度
     */
    protected int speed;

    /**
     * 生命
     */
    protected boolean life;

    /**
     * 暂停状态
     */
    protected boolean pause;

    /**
     * todo 写好注释
     */
    protected boolean swift;

    // todo 写好注释
    protected int swiftSpeed= Global.SWIFT_SPEED;

    // todo 写好注释
    protected Thread shapeThread, swiftThread;

    /**
     * 颜色
     */
    protected Color color = Color.BLUE;






}
