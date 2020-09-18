# Use_Json_in_Java

## 入力値

``` json
[
  {"value": "New", "onclick": "CreateNewDoc()"},
  {"value": "Open", "onclick": "OpenDoc()"},
  {"value": "Test", "onclick": ""},
  {"value": "Test2"}
]
```

## 実行コマンド

```
mvn exec:java -Dexec.mainClass='sample.json.App' -Dexec.args='./input/sample.json'
```

## 実行結果

```
MenuItem(value=New, onclick=CreateNewDoc()) : onclick is not null.
MenuItem(value=Open, onclick=OpenDoc()) : onclick is not null.
MenuItem(value=Test, onclick=) : onclick is not null.
MenuItem(value=Test2, onclick=null) : onclick is null.
```

## 参考

[JSON Example](https://json.org/example.html)  
jsonファイルの取得元。

