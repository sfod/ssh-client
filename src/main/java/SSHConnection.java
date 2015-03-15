/**
 * Created by sfod on 3/15/15.
 */

import com.jcraft.jsch.*;

public class SSHConnection {

    private JSch jsch;
    private Session session;
    private Channel channel;

    public SSHConnection() {
        jsch = new JSch();
        try {
            jsch.setKnownHosts("/home/sfod/.ssh/known_hosts");
        } catch (JSchException e) {
            e.printStackTrace();
        }
        session = null;
        channel = null;
    }

    public void connect(String user, String host, int port)
            throws RuntimeException {
        session = null;
        try {
            jsch.setKnownHosts("/home/sfod/.ssh/known_hosts");
            session = jsch.getSession(user, host, 22);
            session.setPassword("ieGeeNe5m");
            session.connect();
        } catch (JSchException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void close() {
        if (channel != null) {
            channel.disconnect();
        }
        if (session != null) {
            session.disconnect();
        }
    }

    public void execCmd(String cmd) throws RuntimeException {
        channel = null;
        try {
            channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(cmd);
            channel.connect();
        } catch (JSchException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
