# Use_Json_in_Java

## 通常の読み込み

### 入力値

``` json
[
  {"value": "New", "onclick": "CreateNewDoc()"},
  {"value": "Open", "onclick": "OpenDoc()"},
  {"value": "Test", "onclick": ""},
  {"value": "Test2"}
]
```

### 実行コマンド

```
mvn exec:java -Dexec.mainClass='sample.json.App' -Dexec.args='./input/sample.json'
```

### 実行結果

```
MenuItem(value=New, onclick=CreateNewDoc()) : onclick is not null.
MenuItem(value=Open, onclick=OpenDoc()) : onclick is not null.
MenuItem(value=Test, onclick=) : onclick is not null.
MenuItem(value=Test2, onclick=null) : onclick is null.
```

## Bean → JSON生成時にnullをから文字に変換する

### 入力値

```
[
  {"value": "New", "onclick": "CreateNewDoc()"},
  {"value": "Open", "onclick": "OpenDoc()"},
  {"value": "Test", "onclick": null},
  {"value": "Test2" },
  {"value": null , "onclick": "Test3"},
  {"onclick": "Test4"},
  {}
]
```

### 実行コマンド

```
mvn exec:java -Dexec.mainClass='sample.json.App' -Dexec.args='./input/sample.json'
```

### 実行結果

```
MenuItem(value=New, onclick=CreateNewDoc()) : onclick is not null.
MenuItem(value=Open, onclick=OpenDoc()) : onclick is not null.
MenuItem(value=Test, onclick=null) : onclick is null.
MenuItem(value=Test2, onclick=null) : onclick is null.
MenuItem(value=null, onclick=Test3) : onclick is not null.
MenuItem(value=null, onclick=Test4) : onclick is not null.
MenuItem(value=null, onclick=null) : onclick is null.
```

``` json
[
  {                                                                                                                                                                       
    "value": "New",                                                                                                                                                       
    "onclick": "CreateNewDoc()"                                                                                                                                           
  },                                                                                                                                                                      
  {                                                                                                                                                                       
    "value": "Open",                                                                                                                                                      
    "onclick": "OpenDoc()"                                                                                                                                                
  },                                                                                                                                                                      
  {                                                                                                                                                                       
    "value": "Test",                                                                                                                                                      
    "onclick": ""                                                                                                                                                         
  },                                                                                                                                                                      
  {                                                                                                                                                                       
    "value": "Test2",                                                                                                                                                     
    "onclick": ""                                                                                                                                                         
  },                                                                                                                                                                      
  {                                                                                                                                                                       
    "value": "",                                                                                                                                                          
    "onclick": "Test3"                                                                                                                                                    
  },                                                                                                                                                                      
  {                                                                                                                                                                       
    "value": "",                                                                                                                                                          
    "onclick": "Test4"                                                                                                                                                    
  },                                                                                                                                                                      
  {                                                                                                                                                                       
    "value": "",                                                                                                                                                          
    "onclick": ""                                                                                                                                                         
  }                                                                                                                                                                       
]              
```

### 変換方法
JacksonObjectMapper.javaを参照。

## 参考

[JSON Example](https://json.org/example.html)  
jsonファイルの取得元。
