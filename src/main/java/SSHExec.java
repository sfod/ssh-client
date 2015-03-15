/**
 * Created by sfod on 3/15/15.
 */

public class SSHExec {
    public static void main(String[] args) {
        SSHConnection sshc = new SSHConnection();
        sshc.connect("sfod", "192.168.1.217", 22);
        sshc.execCmd("touch /tmp/1");
        sshc.close();
    }
}
