# springboot-pagination

* Spring Boot、myBatis、H2DBの場合の簡単なページネーションサンプルです。
* Spring Bootアプリケーションを実行し、localhost:8080のURLを入力すれば、ページネーションを実装したユーザ一覧のサンプル画面が表示されます
* ページネーションの部品としては以下を見るとよいです。
  * com.example.fw.web.page.PageInfo, com.example.fw.web.page.PageInfoDialect
  * /springboot-pagination/src/main/resources/templates/layout/parts.html
* 部品を使ったThymeleafの画面の例は
  * /springboot-pagination/src/main/resources/templates/user/userList.html
* ページネーションを使った処理は
  * com.example.app.user.controller.UserController#getUserList
  * com.example.domain.service.UserServiceImpl#findAllForPagination
  * com.example.domain.common.repository.UserRepository#findAllForPagination(Pageable)
* SQLは
  * /springboot-pagination/src/main/resources/com/example/domain/common/repository/UserRepository.xml
    * idが"findAllForPagination"のもの
    * H2DBで動作するAPでLIMIT OFFSETを使っているのでPostgreSQLやMySQL等はそのままのSQLでOKのはず
    * Oracleだと文法が違うので注意
      * 例えば12c以降ならOFFSET n ROWSとFETCH FIRST n ROWS ONLYを使う     
    


