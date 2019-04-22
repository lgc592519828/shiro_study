# shiro-day02

## 身份验证

* 整理身份验证步骤  
   1. 获取表单username，password。
   2. 获取shiro的Subject对象  SecurityUtils.getSubject()。
   3. 创建身份验证的Token，调用subject.login(token)方法。 
   4. 最后根据返回信息来判断身份验证结果，通常根据返回的异常来判断身份验证状态 。
   5. 如果身份验证失败请捕获AuthenticationException或其子类，常见的如：  
      DisabledAccountException（禁用的帐号）、LockedAccountException（锁定的帐号）、UnknownAccountException（错误的帐号）、      ExcessiveAttemptsException（登录失败次数过多）、IncorrectCredentialsException （错误的凭证）、ExpiredCredentialsException（过期的凭证）等，具体请查看其继承关系；对于页面的错误消息展示，最好使用如“用户名/密码错误”而不是“用户名错误”/“密码错误”，防止一些恶意用户非法扫描帐号库
   6. 最后可以调用subject.logout退出，其会自动委托给SecurityManager.logout方法退出。

* 总结身份验证细节流程  
   1. 首先调用Subject.login(token)进行登录，其会自动委托给Security Manager。   
   2. SecurityManager负责身份验证逻辑，它会委托给Authenticator认证器进行身份验证，可以自定义实现。   
   3. Authenticator可能会委托给相应的AuthenticationStrategy，进行ModularRealmAuthenticator中Realm身份验证，可以选择单realm和多realm认证。  
   4. Authenticator会把相应的token传入Realm，从Realm获取身份验证信息，如果没有返回/抛出异常表示身份验证失败了。此处可以配置多个Realm，将按照相应的顺序及策略进行访问。
   
* shiro源码查看验证流程，以便于理解    
   
