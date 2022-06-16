package entities;

import listener.GroundListener;
import util.Global;

import java.util.HashSet;
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

    protected Set<GroundListener> listeners = new HashSet<GroundListener>();

    /**
     * 容器
     */
    protected UnitType[][] obstacle = new UnitType[Global.WIDTH][Global.HEIGHT];


}
