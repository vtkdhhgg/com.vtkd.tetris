package listener;

import entities.Shape;

/**
 * 图形监听器
 *
 * @version 1.0 2022/6/17
 *
 * @author vtkd
 */
public interface ShapeListener {
    /**
     * 图形询问是否可以下落
     *
     * @param shape
     * @return
     */
    boolean isShapeMoveDownable(Shape shape);

    /**
     * 图形下落事件
     *
     * @param shape
     */
    void shapeMoveDown(Shape shape);
}
