/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mouse.colector;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.POINT;
import java.time.LocalDateTime;

/**
 *
 * @author rafae
 */
public class Mouse {

    private POINT lastMousePosition;
    private long lastActivityTime;
    private long timeout;
    private LocalDateTime lastCurrrentTime;
    private Integer currentx;
    private Integer currenty;
    private Integer lastx;
    private Integer lasty;
    private Boolean movimento;

    public POINT getMousePosition() {

        POINT point = new POINT();
        User32.INSTANCE.GetCursorPos(point);

        return point;
    }

}
