# Architecture Documentation

## 📋 プロジェクト概要

このプロジェクトは、Spring BootとThymeleafを使用したWebアプリケーションです。
MVCアーキテクチャパターンを採用し、サーバーサイドレンダリングによる動的なWebページを提供します。

## 🛠 技術スタック

### フレームワーク・ライブラリ
- **Spring Boot 3.5.0** - メインフレームワーク
- **Spring Web** - Web MVC機能
- **Spring Boot DevTools** - 開発時のホットリロード
- **Thymeleaf** - テンプレートエンジン

### 言語・ランタイム
- **Java 21** - プログラミング言語
- **Maven** - ビルドツール・依存関係管理

### 開発ツール
- **Maven Wrapper** - プロジェクト固有のMavenバージョン管理
- **LiveReload** - ブラウザ自動更新機能

## 🏗 アーキテクチャパターン

### MVCパターン (Model-View-Controller)

```
┌─────────────────┐    HTTP Request     ┌─────────────────┐
│                 │ ──────────────────► │                 │
│   Web Browser   │                     │   Controller    │
│                 │ ◄────────────────── │   (@Controller) │
└─────────────────┘    HTTP Response    └─────────────────┘
                                                │
                                                │ 処理・データ準備
                                                ▼
                                        ┌─────────────────┐
                                        │                 │
                                        │     Model       │
                                        │   (データ)       │
                                        │                 │
                                        └─────────────────┘
                                                │
                                                │ データバインディング
                                                ▼
                                        ┌─────────────────┐
                                        │                 │
                                        │      View       │
                                        │  (Thymeleaf)    │
                                        │                 │
                                        └─────────────────┘
```


## 📁 ディレクトリ構成

```
Thymeleaf-Spring-Boot/
├── .mvn/                          # Maven Wrapper設定
│   └── wrapper/
│       └── maven-wrapper.properties
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/demo/
│   │   │       ├── DemoApplication.java      # メインアプリケーションクラス
│   │   │       └── HelloController.java      # Webコントローラー
│   │   └── resources/
│   │       ├── static/                       # 静的ファイル(CSS, JS, Images)
│   │       ├── templates/                    # Thymeleafテンプレート
│   │       │   └── hello.html
│   │       └── application.properties        # アプリケーション設定
│   └── test/                                 # テストコード
├── target/                                   # ビルド成果物
├── pom.xml                                   # Maven設定
├── mvnw / mvnw.cmd                          # Maven Wrapper
├── HELP.md                                   # ヘルプドキュメント
└── ARCHITECTURE.md                           # このファイル
```

## 🔧 主要コンポーネント

### 1. アプリケーション起動クラス
**`DemoApplication.java`**
- `@SpringBootApplication`アノテーションによる自動設定
- アプリケーションのエントリーポイント

### 2. Webコントローラー
**`HelloController.java`**
- `@Controller`アノテーションによるMVCコントローラー
- `@GetMapping`によるHTTPルーティング
- `Model`オブジェクトを使用したビューへのデータ渡し

### 3. ビューテンプレート
**`hello.html`**
- Thymeleaf記法によるサーバーサイドレンダリング
- `th:text`、`th:*`属性によるデータバインディング
- レスポンシブ対応のCSS

## 🔄 リクエストフロー

1. **ユーザーアクセス**: ブラウザから`/hello`にアクセス
2. **ルーティング**: Spring MVCが`HelloController.hello()`メソッドを呼び出し
3. **データ準備**: Controllerが`Model`にデータを設定
4. **ビュー解決**: Thymeleafが`hello.html`テンプレートを処理
5. **レンダリング**: テンプレートとデータを結合してHTMLを生成
6. **レスポンス**: 生成されたHTMLをブラウザに返送

## 🎯 設計原則

### 1. 関心の分離 (Separation of Concerns)
- **Controller**: HTTPリクエスト処理とレスポンス制御
- **Model**: データの格納と受け渡し
- **View**: プレゼンテーション層の責務

### 2. 設定より規約 (Convention over Configuration)
- Spring Bootの自動設定機能を活用
- 標準的なディレクトリ構成を採用

### 3. DRY原則 (Don't Repeat Yourself)
- Thymeleafテンプレートの再利用
- Spring Bootのスターター依存関係活用

## 🔧 開発環境設定

### 必要ソフトウェア
- Java 21+
- Maven 3.6+（または内蔵のMaven Wrapper使用）

### 起動方法
```bash
# Maven Wrapperを使用
./mvnw spring-boot:run

# または直接Maven使用
mvn spring-boot:run
```

### ホットリロード
Spring Boot DevToolsにより以下が自動実行されます：
- Javaクラス変更時の自動再起動
- 静的ファイル変更時のLiveReload
- 設定ファイル変更の即座反映

## 🚀 拡張ポイント

### 1. データベース連携
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

### 2. セキュリティ
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

### 3. RESTful API
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webflux</artifactId>
</dependency>
```

### 4. テスト強化
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
</dependency>
```

## 📝 コーディング規約

### ファイル命名
- **Controller**: `*Controller.java`
- **Service**: `*Service.java`
- **Repository**: `*Repository.java`
- **Entity**: `*.java`（名詞）
- **Template**: `*.html`

### パッケージ構成
```
com.example.demo/
├── controller/     # Webコントローラー
├── service/        # ビジネスロジック
├── repository/     # データアクセス
├── entity/         # エンティティクラス
├── dto/           # データ転送オブジェクト
└── config/        # 設定クラス
```

## 🔍 モニタリング・ログ

### Actuator（将来的な拡張）
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

### ログ設定
- デフォルト：コンソール出力
- カスタマイズ：`application.properties`で設定可能

---

## 📚 参考リンク

- [Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html)
- [Spring MVC Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html) 