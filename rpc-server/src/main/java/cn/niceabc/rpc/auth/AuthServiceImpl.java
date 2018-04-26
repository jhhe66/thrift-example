package cn.niceabc.rpc.auth;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthServiceImpl implements RPCNetAuthService.Iface {
    private static Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);

    public boolean login(String username, String password) throws TException {
        log.debug("login,{}", username);
        return true;
    }
}
