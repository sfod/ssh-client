package me.sfod;

import junit.framework.TestCase;
import org.junit.Test;

import java.lang.Override;

public class SSHConnectionTest extends TestCase {
    private SSHConnection sshconn;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.sshconn = new SSHConnection();
    }

    @Test
    public void testConnect() throws Exception {
//        sshconn.connect("sfod", "sfod.me", 22);
//        sshconn.close();
    }

    @Test
    public void testClose() throws Exception {
//        sshconn.connect("sfod", "sfod.me", 22);
//        sshconn.close();
    }

    @Test
    public void testExecCmd() throws Exception {
        sshconn.connect("sfod", "sfod.me", 22);
        sshconn.execCmd("echo hell > /tmp/1");
        sshconn.close();
    }
}