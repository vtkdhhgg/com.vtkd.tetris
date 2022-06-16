package view;

import entities.Ground;
import util.Global;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * 游戏的显示界面
 * 可以用 setBackgroundColor() 设置游戏的背景颜色
 *
 * @author 君上
 * @version 1.0 2022.6.10
 */
public class GamePanel extends JPanel {

    public static final Color DEFAULT_BACKGROUND_COLOR = new Color(0xfcfcf);
    private static final long serialVersionUID = 1L;
    /**
     * 背景颜色
     */
    protected Color backgroundColor = DEFAULT_BACKGROUND_COLOR;
    private Image oimg;
    private Graphics og;


    public GamePanel() {
        /* 设置大小和布局 使用了工具类 Global类中的属性(从配置文件中读取而来) */
        this.setSize(Global.WIDTH * Global.CELL_WIDTH, Global.HEIGHT * Global.CELL_HEIGHT);

        /* 设置游戏界面的边框 */
        this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));

        /* 设置该组件状态聚焦 */
        this.setFocusable(true);

    }

    public synchronized void redisplay(Ground ground, Shape shape){

    }


}
