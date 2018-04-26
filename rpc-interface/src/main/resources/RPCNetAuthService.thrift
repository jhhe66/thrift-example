namespace java cn.niceabc.rpc.auth

service RPCNetAuthService {
    bool login(1:string username, 2:string password)
}