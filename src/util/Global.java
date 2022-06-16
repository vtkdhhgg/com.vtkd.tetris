package util;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

/**
 * 工具类
 *
 * 此类中存放了其它类中用到的一些常量
 * 并且支持配置文件
 * 配置文件的路劲为游戏的运行的目录,文件名为: tetris.ini
 *
 * 配置文件的写法参见字段的注释
 * 配置文件中设置项可以只写需要配置的,没有写的设置项默认为缺省值
 * 各配置项的缺省值参见字段的注释
 *
 * 每个配置项都有设置范围,超出范围(无效)的设置值将不起作用
 *
 * @version 1.1 2022/6/1
 *
 * @author 君上
 */
public class Global {

    // 配置文件类
    private static Properties properties = new Properties();

    /**
     * 配置文件的路径(默认为当前目录下的 snake.ini 文件)
     */
    private static final String CONFIG_FILE = "tetris.ini";

    /**
     * 一个格子的宽度, 单位:像素
     * 对应的配置文件中的关键字为:cell_width, 或用cell_size指定
     * 范围1-100
     * 缺省值为 23
     */
    public static final int CELL_WIDTH;

    /**
     * 一个格子的高度,单位:像素
     * 对应的配置文件中的关键字为:cell_height, 或用cell_size指定
     * 范围:1-100
     * 缺省值:23
     */
    public static final int CELL_HEIGHT;

    /**
     * 用格子表示的宽度,(宽度为多少个格子)单位:格
     * 对应的配置文件中的关键字为:width
     * 范围10-80
     * 缺省值: 15
     */
    public static final int WIDTH;

    /**
     * 用格子表示高度,(高度为多少个格子), 单位:格
     * 对应的配置文件中的关键字为: height
     * 范围10-60
     * 缺省值: 20
     */
    public static final int HEIGHT;

    /**
     * 图形下落的初始速度(单位:毫秒/格)
     * 对应的配置文件中的关键字为:speed
     * 范围10-无限大
     * 缺省值:200
     */
    public static final int DEFAULT_SPEED;

    /**
     * 保存当前游戏中图形的下落速度
     */
    public static int CURRENT_SPEED;

    /**
     * 图形快速下落的速度(单位:毫秒/格)
     * 对应的配置文件中的关键字为:swift_speed
     * 范围0-无限大
     * 缺省值为 15
     */
    public static final int SWIFT_SPEED;

    /**
     * 每次加速或减速的幅度(单位:毫秒/格)
     * 对应的配置文件的关键字为:speed_ster
     * 范围:1-无限大
     * 缺省值:25
     */
    public static final int SPEED_STER;

    /**
     * 消除满行前暂停效果的时间(单位:毫秒)
     * 对应的配置文件的关键字为:stay_time
     * 范围0-无限大
     * 缺省值:200
     */
    public static  final int DEFAULT_STAY_TIME;

    /**
     * 消除满行前暂停效果的时间
     */
    public static int STAY_TIME;

    /**
     * 创建一个随机数对象
     */
    public static Random random = new Random();


    /**
     * TODO:写好注释 TITLE_LABEL_TEXT 的意义
     * 标题文本
     */
    public static final String TITLE_LABEL_TEXT;

    /**
     * TODO:写好注释 INFO_LABEL_TEXT 的意义
     * 可能是输入的标题
     */
    public static final String INFO_LABEL_TEXT;

    /**
     * 颜色的数组:6种颜色
     */
    private static final Color[] DEFAULT_COLORS = new Color[]{
            new Color(0x990066), new Color(0x990099), new Color(0x330099),
            new Color(0x663300), new Color(0x009966), new Color(0x003333)
    };

    /**
     * TODO COMMON_COLORS 的用处
     * 可能是存放公用的colors list集合
     */
    public static final List<Color> COMMON_COLORS;

    /**
     * 返回一个随机的颜色
     * @return Color 颜色对象
     */
    public static Color getRandomColor(){
        // DEFAULT_COLORS.length = 6
        return DEFAULT_COLORS[random.nextInt(DEFAULT_COLORS.length)];
    }


    /**
     * 默认的Global构造器,私有的,不能生成这个类的实例
     */
    private Global(){
    }

    /*
      初始化常量
     */
    static{
        // 用来读取配置文件的 输入流
        InputStream inputStream = null;

        try {
            inputStream= new FileInputStream(CONFIG_FILE);
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            System.out.println("没有配置文件");
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try {
                if (inputStream != null) {
                        inputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        Integer temp;

        // 初始化各种属性
        WIDTH = (temp = getIntValue("width")) != null && temp <= 80
                && temp >= 10 ? temp : 15;

        HEIGHT = (temp = getIntValue("height")) != null && temp <= 60
                && temp >= 10 ? temp : 20;

        DEFAULT_SPEED = CURRENT_SPEED = (temp = getIntValue("speed")) != null
                && temp >= 10 ? temp : 20;

        SWIFT_SPEED = (temp = getIntValue("swift_speed")) != null
                && temp >= 0 ? temp : 15;

        SPEED_STER = (temp = getIntValue("speed_ster")) != null
                && temp >=1 ? temp : 25;

        DEFAULT_STAY_TIME = STAY_TIME = (temp = getIntValue("stay_time")) != null
                && temp >= 0 ? temp : 200;

        // 读取了设置: CELL_WIDTH, CELL_HEIGHT 值的属性
        int defaultCellSize = (temp = getIntValue("cell_size")) != null
                && temp > 0 && temp <= 100 ? temp :23;

        CELL_WIDTH  = (temp = getIntValue("cell_width")) != null
                && temp >= 1 && temp <= 100 ? temp : defaultCellSize;

        CELL_HEIGHT = (temp = getIntValue("cell_height")) != null
                && temp >= 1 && temp <= 100 ? temp : defaultCellSize;

        // 用来做 字符串配置值的临时变量
        String tempStr;
        TITLE_LABEL_TEXT = (tempStr = getValue("title")) == null
                ? "说明:" : tempStr;

        INFO_LABEL_TEXT = (tempStr = getValue("info")) == null
                ? "方向键控制方向, 回车键暂停/继续\nPAGE UP, PAGE DOWN 加速或减速\n\n 欢迎游玩君上开发的俄罗斯方块" : tempStr;

        // 加载 Colors
        COMMON_COLORS = loadColors();
    }







    /**
     * 要考虑多种情况
     * 1. 没有这个key 和value
     * 2. 有key 没有value
     * @param key 配置文件中配置项的名字
     * @return Integer
     */
    private static Integer getIntValue(String key) {
        if (key == null) {
            throw new RuntimeException("key 不能为空");
        }
        try{
            // 通过 properties 获取配置文件对应key 的值
            return Integer.valueOf(properties.getProperty(key));
        }catch (NumberFormatException e){
            return null;
        }
    }

    /**
     * 要考虑多种情况
     * 1. 没有这个key 和value
     * 2. 有key 没有value
     * @param key 配置文件中配置项的名字
     * @return String 配置项的 value
     */
    public static String getValue(String key){
        try {
            return Arrays.toString(properties.getProperty(key).getBytes("iso8859-1"));
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 加载 颜色
     * @return 加载好的 colors list集合
     */
    @SuppressWarnings("unckecked")
    public static List<Color> loadColors(){
        ArrayList<Color> colors = new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
            colors.add(null);
        }

        Set<Object> keySet = properties.keySet();

        // 获取参数的遍历器
        // 循环从配置文件中获取color数据,将其添加到colors中
        for (Object o : keySet) {
            String key = (String) o;
            key = key.trim();
            switch (key) {
                case "1":
                    addColor(colors, 0, getValue(key));
                    break;
                case "2":
                    addColor(colors, 1, getValue(key));
                    break;
                case "3":
                    addColor(colors, 2, getValue(key));
                    break;
                case "4":
                    addColor(colors, 3, getValue(key));
                    break;
                case "5":
                    addColor(colors, 4, getValue(key));
                    break;
                case "6":
                    addColor(colors, 5, getValue(key));
                    break;
                case "7":
                    addColor(colors, 6, getValue(key));
                default:
            }
        }

        for (int j = 0; j < 7; j++) {
            colors.remove(null);
        }

        if (colors.size() < 1){
//            for (int j = 0; j < DEFAULT_COLORS.length; j++) {
//                // 将默认的颜色 DEFAULT_COLORS 添加到 colors中
//                colors.add(DEFAULT_COLORS[j]);
//            }
            // 将默认的颜色 DEFAULT_COLORS 添加到 colors中
            // 用addAll() 代替 迭代器循环添加.
            colors.addAll(Arrays.asList(DEFAULT_COLORS));
        } else {
            if (colors.size() != 7){
                System.out.println("您一共设置了 " + colors.size() + " 种有效颜色, 建议设置七种有效颜色.");
            }
//                return colors.subList(0, colors.size() > 7 ? 7 : colors.size());
            return colors.subList(0, Math.min(colors.size(), 7));
        }

        return colors;
    }

    /**
     * 向 colors 中添加 数据, 根据 index 和 key(颜色代码)
     * @param colors color 的list集合
     * @param index 索引:colors中的索引值
     * @param str 颜色的 字符串
     */
    @SuppressWarnings("unchecked") // idea 提示这个是冗余 查一下
    private static void addColor(List<Color> colors, int index, String str){
         str = str.trim();
        if (!str.startsWith("0x") || str.length() < 3){
            System.out.println("颜色设置有误,请检查 : " + str + "(key)");
            // 让这个方法就在这里返回, 下面的代码不用执行了
            return;
        }

        try {
//        str.substring(2, str.length() >= 8 ? 8 : str.length());
            String strRGB = str.substring(2, Math.min(str.length(), 8));

            // todo 不懂 查看一下api Integer.valueOf() 方法的用法
            Integer rgb = Integer.valueOf(strRGB, 16);
            Color color = new Color(rgb);
//            if (color != null) {
//                colors.add(index, color);
//            }
            colors.add(index, color);

        } catch (Exception e) {
            System.out.println("(e)颜色设置有误,请检查:" + str + "(key)");
            e.printStackTrace();
        }
    }















}
