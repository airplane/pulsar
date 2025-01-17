package meteordevelopment.pulsar.rendering;

import meteordevelopment.pts.utils.ColorFactory;
import meteordevelopment.pts.utils.IColor;
import meteordevelopment.pulsar.utils.Matrix;
import meteordevelopment.pulsar.widgets.Cell;
import meteordevelopment.pulsar.widgets.Widget;
import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;

public class DebugRenderer {
    private static final IColor CELL_COLOR = ColorFactory.create(25, 225, 25, 255);
    private static final IColor WIDGET_COLOR = ColorFactory.create(25, 25, 225, 255);

    private static final FloatBuffer PROJECTION = MemoryUtil.memAllocFloat(16);

    private static Shader shader;
    private static Mesh mesh;

    private static void lazyInit() {
        if (shader == null) {
            shader = new Shader("/pulsar/shaders/basic.vert", "/pulsar/shaders/basic.frag");
            mesh = new Mesh(Mesh.Attrib.Vec2, Mesh.Attrib.Color);
        }
    }

    public static void render(Widget widget, int windowWidth, int windowHeight) {
        lazyInit();
        mesh.begin();

        render(widget);

        shader.bind();
        shader.set("u_Proj", Matrix.ortho(PROJECTION, 0, windowWidth, windowHeight, 0, -10000, 10000));
        mesh.render(true);
    }

    private static void render(Widget widget) {
        lineBox(widget.x, widget.y, widget.width, widget.height, WIDGET_COLOR);

        for (Cell<?> cell : widget) {
            lineBox(cell.x, cell.y, cell.width, cell.height, CELL_COLOR);
            render(cell.widget());
        }
    }

    private static void lineBox(double x, double y, double width, double height, IColor color) {
        line(x, y, x + width, y, color);
        line(x + width, y, x + width, y + height, color);
        line(x, y, x, y + height, color);
        line(x, y + height, x + width, y + height, color);
    }

    private static void line(double x1, double y1, double x2, double y2, IColor color) {
        mesh.line(
                mesh.vec2(x1, y1).color(color).next(),
                mesh.vec2(x2, y2).color(color).next()
        );
    }
}
