package entities;

import listener.GroundListener;
import util.Global;

import java.awt.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 地形, 地面
 * 维护障碍物的信息
 * 可以使用提供的 addObstacle(int, int) 和 addStubbornObstacle(int, int) 方法添加障碍物.
 *
 * 可以通过setObstacleColor(), setStubbornObstacleColor() 或者
 * setGriddingColor() 方法更改障碍物或网格的颜色
 * 通过 setDrawGrdding() 方法设置是否画空白(网格)
 * 用 setColorFulSupport() 方法设置是否支持彩色显示
 *
 * 覆盖 drawObstacle(Graphics, int, int, int, int) 方法可以改变障碍物的显示方式
 * 覆盖 drawStubbornObstacle(Graphics, int, int, int, int) 方法可以改变不可消除的障碍物的显示方式
 *
 * @version 1.0 2022.6.10
 *
 * @author 君上
 *
 */
public class Ground {

    /**
     * 监听器
     */
    protected Set<GroundListener> listeners = new HashSet<GroundListener>();

    /**
     * 容器
     */
    protected UnitType[][] obstacles = new UnitType[Global.WIDTH][Global.HEIGHT];

    /**
     * 不可消除的障碍物的颜色
     */
    protected Color stubbornObstacleColor = UnitType.STUBBORN_OBSTACLE.getColor();

    /**
     * 默认的网格颜色
     */
    public static final Color DEFAULT_GRIDDING_COLOR = Color.LIGHT_GRAY;

    /**
     * 网格的颜色
     */
    protected Color griddingColor = DEFAULT_GRIDDING_COLOR;

    /**
     * 默认的障碍物颜色
     */
    public static final Color DEFAULT_OBSTACLE_COLOR = UnitType.OBSTACLE.getColor();

    /**
     * 障碍物的颜色
     */
    protected Color obstacleColor = DEFAULT_OBSTACLE_COLOR;

    public static final Color DEFAULT_FULL_LINE_COLOR = Color.DARK_GRAY;
    /**
     * 满行的颜色
     */
    protected Color fullLineColor = DEFAULT_FULL_LINE_COLOR;

    /**
     * 是否画网格 的开关
     */
    protected boolean drawGrdding;

    /**
     * 是否支持彩色石头
     */
    protected boolean colorfulSupport;

    /**
     * 是否还能接受石头
     */
    protected boolean full;

    protected Random random = new Random();

    public Ground(){
        init();
    }

    /**
     * 初始化,将会调用clear() 方法
     */
    public void init(){
        clear();
        full = false;
    }

    /**
     * 清空容器
     */
    public void clear() {
        /*
        * 初始化数组
        * */
        for(int x = 0; x < Global.WIDTH; x++){
            for(int y = 0; y < Global.HEIGHT; y++){
                obstacles[x][y] = UnitType.BLANK.clone();
            }
        }
    }

    /**
     * 随机生成一个不可消除的障碍物,这个随机的坐标的 y 坐标不小于5
     */
    public void genernateAStubbornStochasticObstacle(){
        Random random = new Random();
        if (Global.HEIGHT<5) return;
        int y = random.nextInt(5) + Global.HEIGHT - 5;
        int x = random.nextInt(Global.WIDTH);
        addStubbornObstacle(x, y);
    }

    /**
     * 在指定的范围内随机生成一些障碍物
     * @param amount
     *  要生成的数量
     * @param lineNum
     *  行号,从 1 开始
     */
    public void generateSomeStochasticObstacle(int amount, int lineNum){
        if (lineNum < 1) {
            return;
        }
        if (lineNum > Global.HEIGHT) {
            lineNum = Global.HEIGHT;
        }
        for (int i = 0; i < amount; i++) {
            int x = random.nextInt(Global.WIDTH);
            int y = random.nextInt(lineNum) + Global.HEIGHT - lineNum;
            obstacles[x][y] = UnitType.OBSTACLE.clone();
            obstacles[x][y].setColor(Global.getRandomColor());
        }
    }

    /**
     * 把指定的图形变成石头
     * 然后将会调用 deletFullLine() 方法扫描并删除满行
     * @param shape
     */
    public void accept(Shape shape){
        /*
        把图形对应的坐标变成石头
         */
//        int left = shape.
    }

    /**
     * 在指定的位置添加一块不可消除的障碍物
     * @param x
     *  x 格子坐标
     * @param y
     *  y 格子坐标
     */
    public void addStubbornObstacle(int x, int y){
        if (x < 0 || x >= Global.WIDTH || y < 0 || y >= Global.HEIGHT){
            throw new RuntimeException("这个位置超出了显示区域(x:" + x + " y:" + y + ")");
        }
        obstacles[x][y].cloneProperties(UnitType.OBSTACLE);
    }

































}
