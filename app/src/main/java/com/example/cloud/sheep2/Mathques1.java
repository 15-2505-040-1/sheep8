package com.example.cloud.sheep2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by cloud on 2017/11/15.
 */

public class Mathques1 implements Serializable {
    int q_num; // 問題番号
    String q_string; // 第○問というString
    String question; //問題文
    int image; // 画像ID
    String[] choices = new String[4]; // 選択肢
    int answer_index; // 正解の選択肢


    private static Mathques1[] quizzes = new Mathques1[100]; // クイズの配列

    private Mathques1(int q_num, String question, String[] choices, int answer_index) {
        this.q_num = q_num;
        this.q_string = q_string;
        this.question = question;
        this.image = image;
        this.choices = choices;
        this.answer_index = answer_index;
    }

    // 問題登録
    public static void init() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <= 49; i++) {
            list.add(i);
        }
        //listをシャッフル
        Collections.shuffle(list);

        int r=0;

        quizzes[list.get(r+1)] = new Mathques1(list.get(r+1),"第二次世界大戦で，日本に原子爆弾が落とされたときにアメリカの大統領を務めていたのは誰でしょう？\n\n1.トルーマン\t2.アイゼンハワー\n3.ウィルソン\t4.Ｆ．ルーズベルト", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+2)] = new Mathques1(list.get(r+2),"イエズス会の宣教師フランシスコ=ザビエルが日本に来たとき，最初に上陸した場所はどこでしょう？\n\n1.鹿児島　　\t2.長　崎　\n3.種子島\t4.根　室", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+3)] = new Mathques1(list.get(r+3),"安土桃山時代に「唐獅子図屏風（からじしずびょうぶ）」を描いた画家の名前は何でしょう？\n\n1.雪舟\t2.狩野永徳\n3.葛飾北斎\t4.海北友松", new String[]{"(1)", "(2)", "(3)", "(4)"}, 1);
        quizzes[list.get(r+4)] = new Mathques1(list.get(r+4),"鎌倉時代に，北条義時を討つよう命令を出した上皇の名前を何と言うでしょう？\n\n1.後鳥羽上皇\t2.後白河上皇\n3.崇徳上皇\t4.白河上皇", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+5)] = new Mathques1(list.get(r+5),"1915(大正４)年に，中国の袁世凱政府に二十一カ条の要求を突きつけたときの，日本の首相は誰でしょう？\n\n1.伊藤博文\t2.大隈重信\n3.鈴木貫太郎\t4.陸奥宗光", new String[]{"(1)", "(2)", "(3)", "(4)"}, 1);
        quizzes[list.get(r+6)] = new Mathques1(list.get(r+6),"天智天皇が定めた，日本で最初の令を何と言うでしょう？\n\n1.近江令\t2.飛鳥浄御原令\n3.養老律令\t4.大宝律令", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+7)] = new Mathques1(list.get(r+7),"次の中から，室町時代の三管領にあてはまらないのはどれでしょう？\n\n1.斯波氏\t2.山名氏\n3.細川氏\t4.畠山氏", new String[]{"(1)", "(2)", "(3)", "(4)"}, 1);
        quizzes[list.get(r+8)] = new Mathques1(list.get(r+8),"江戸時代に「古事記伝」を著し，国学を大成した人は誰でしょう？\n\n1.滝沢馬琴\t2.前野良沢\n3.吉田兼好\t　　\t4.本居宣長", new String[]{"(1)", "(2)", "(3)", "(4)"}, 3);
        quizzes[list.get(r+9)] = new Mathques1(list.get(r+9),"次の中から「更級日記」の作者を選びなさい。\n\n1.清少納言\t2.菅原孝標の女\n3.藤原道綱の母\t　\t4.紫式部", new String[]{"(1)", "(2)", "(3)", "(4)"}, 1);
        quizzes[list.get(r+10)] = new Mathques1(list.get(r+10),"1932年におこった「五・一五事件」で暗殺された首相は誰でしょう？\n\n1.犬養　毅\t2.加藤高明\n3.東条英機\t4.原　敬", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+11)] = new Mathques1(list.get(r+11),"普通選挙になって１回目の総選挙が行われたのは西暦何年でしょう？\n\n1.1945年\t2.1928年\n3.1890年\t4.1925年", new String[]{"(1)", "(2)", "(3)", "(4)"}, 1);
        quizzes[list.get(r+12)] = new Mathques1(list.get(r+12),"大和朝廷の時代に，豪族が私有していた土地を何というでしょう？\n\n1.田荘\t2.屯倉\n3.荘園\t4.田堵", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+13)] = new Mathques1(list.get(r+13),"次の中から奈良時代に成立した和歌集を選びなさい。\n\n1.金槐和歌集\t2.古今和歌集\n3.新古今和歌集\t4.万葉集", new String[]{"(1)", "(2)", "(3)", "(4)"}, 3);
        quizzes[list.get(r+14)] = new Mathques1(list.get(r+14),"羽柴秀吉が，柴田勝家を破った戦いは，次のうちのどれでしょう？\n\n1.賤ヶ岳の戦い\t2.長篠の戦い\n3.姉川の戦い\t4.富士川の戦い", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+15)] = new Mathques1(list.get(r+15),"日中平和友好条約を結んだときの日本の首相は誰だったでしょう？\n\n1.佐藤栄作\t2.福田赳夫\n3.田中角栄\t4.吉田　茂", new String[]{"(1)", "(2)", "(3)", "(4)"}, 1);
        quizzes[list.get(r+16)] = new Mathques1(list.get(r+16),"鎌倉時代に，武家としての最初の体系的法律である「御成敗式目」を出した執権は誰でしょう？\n\n1.北条泰時\t2.北条時宗\n3.北条高時\t4.北条早雲", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+17)] = new Mathques1(list.get(r+17),"江戸時代に「自然真営道」を著して，万人みずから耕作して生活する自然の世を理想とし，武士が農民から収奪する社会や身分制度を批判した人は誰でしょう？\n\n1.間宮林蔵\t2.伊能忠敬\n3.北畠親房\t4.安藤昌益", new String[]{"(1)", "(2)", "(3)", "(4)"}, 3);
        quizzes[list.get(r+18)] = new Mathques1(list.get(r+18),"1891年に訪日中だったロシアの皇太子が，警備の巡査に切りつけられ負傷した事件を何というでしょう？\n\n1.生麦事件\t2.大津事件\n3.義和団事件\t4.秩父事件", new String[]{"(1)", "(2)", "(3)", "(4)"}, 1);
        quizzes[list.get(r+19)] = new Mathques1(list.get(r+19),"日本人としてはじめて新婚旅行をしたというエピソードを持っている人物は誰でしょう？\n\n1.坂本龍馬\t2.徳川光圀\n3.正岡子規\t4.吉野作造", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+20)] = new Mathques1(list.get(r+20),"平清盛の勢力拡大に反発し，後白河法皇が，近臣の藤原成親や僧俊寛らがめぐらしたはかりごとを何と言うでしょう？\n\n1.鹿ケ谷の陰謀\t2.正中の変\n3.観応の擾乱\t4.安政の大獄", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+21)] = new Mathques1(list.get(r+21),"伊達政宗の家臣で，政宗が派遣した慶長遣欧使節の正使は誰でしょう？\n\n1.片倉小十郎\t2.支倉常長\n3.伊藤マンショ\t4.小西行長", new String[]{"(1)", "(2)", "(3)", "(4)"}, 1);
        quizzes[list.get(r+22)] = new Mathques1(list.get(r+22),"平安時代の書道の名手で，三蹟の一人は誰でしょう？\n\n1.藤原行成\t2.空海\n3.嵯峨天皇\t4.橘逸勢", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+23)] = new Mathques1(list.get(r+23),"1939年ソ連と満州の国境で起こった，日本とソ連の戦闘を何というでしょう？\n\n1.ノモンハン事件\t2.西安事件\n3.シベリア出兵\t4.シーボルト事件", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+24)] = new Mathques1(list.get(r+24),"伊勢神道の理論を背景に南朝の立場から書かれた皇位継承の正しい道理を描いた北畠親房作の歴史書は何でしょう？\n\n1.梅松論（ばいしょうろん）\t2.太平記（たいへいき）\n3.大日本史（だいにほんし）\t4.神皇正統記（じんのうしょうとうき）", new String[]{"(1)", "(2)", "(3)", "(4)"}, 3);
        quizzes[list.get(r+25)] = new Mathques1(list.get(r+25),"江戸時代の傑作「見返り美人図」の作者は誰でしょう？\n\n1.歌川広重（うたがわひろしげ）\t2.菱川師宣（ひしかわもろのぶ）\n3.尾形光琳（おがたこうりん）\t4.葛飾北斎（かつしかほくさい）", new String[]{"(1)", "(2)", "(3)", "(4)"}, 1);
        quizzes[list.get(r+26)] = new Mathques1(list.get(r+26),"1837年に，アメリカの商船が，日本漂流者の送還と日本との貿易開始を交渉するために来日したときに，これを撃退した事件を何と言うでしょう？\n\n1.モリソン号事件\t2.フェ―トン号事件\n3.ゴローウニン事件\t4.ノルマントン事件", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+27)] = new Mathques1(list.get(r+27),"くじ引きで選ばれたことでも有名な室町時代の将軍は誰？\n\n1.足利義昭（あしかがよしあき）\t2.足利義教（あしかがよしのり）\n3.足利義政（あしかがよしまさ）\t4.足利義輝（あしかがよしてる）", new String[]{"(1)", "(2)", "(3)", "(4)"}, 1);
        quizzes[list.get(r+28)] = new Mathques1(list.get(r+28),"江戸時代に天保の改革を行った老中は誰でしょう？\n\n1.徳川吉宗（とくがわよしむね）\t2.田沼意次（たぬまおきつぐ）\n3.松平定信（まつだいらさだのぶ）\t4.水野忠邦（みずのただくに）", new String[]{"(1)", "(2)", "(3)", "(4)"}, 3);
        quizzes[list.get(r+29)] = new Mathques1(list.get(r+29),"室町時代に交通の要地で年貢の保管や運送に当たった業者をなんと言うでしょう？\n\n1.問丸（といまる）\t2.土倉（どそう）\n3.座（ざ）\t4.馬借（ばしゃく）", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+30)] = new Mathques1(list.get(r+30),"平安時代の初期に，国司の交代の際の引継ぎを厳しくするために設けられた役職を何という？\n\n1.勘解由使(かげゆし)\t2.検非違使(けびいし)\n3.蔵人頭(くろうどのとう)\t4.紫微中台(しびちゅうだい)", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+31)] = new Mathques1(list.get(r+31),"明治初期の私擬憲法の一つ「東洋大日本国憲法」を発表したのは誰？\n\n1.植木枝盛(うえきえもり)\t2.星　亨(ほしとおる)\n3.西　周（にしあまね）\t4.江藤新平(えとうしんぺい)", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+32)] = new Mathques1(list.get(r+32),"次の中で，1920年に設立された国際連盟の事務局次長になった日本人は？\n\n1.新渡戸稲造（にとべいなぞう）\t2.吉野作造（よしのさくぞう）\n3.内村鑑三（うちむらかんぞう）\t4.尾崎行雄（おざきゆきお）", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+33)] = new Mathques1(list.get(r+33),"江戸時代、６代、７代将軍のとき、新井白石とともに将軍を補佐した側用人は？\n\n1.田沼意次(たぬまおきつぐ)\t2.間部詮房(まなべあきふさ)\n3.柳沢吉保(やなぎさわよしやす)\t4.土井利勝(どいとしかつ)", new String[]{"(1)", "(2)", "(3)", "(4)"}, 1);
        quizzes[list.get(r+34)] = new Mathques1(list.get(r+34),"1965年、韓国と「日韓基本条約」結んで国交を正常化させたときの首相は？\n\n1.岸信介(きしのぶすけ)\t2.池田勇人(いけだはやと)\n3.鳩山一郎(はとやまいちろう)\t4.佐藤栄作(さとうえいさく)", new String[]{"(1)", "(2)", "(3)", "(4)"}, 3);
        quizzes[list.get(r+35)] = new Mathques1(list.get(r+35),"「平清盛」が一時的に移した都の名前は？\n\n1.福原京(ふくはらきょう)\t2.長岡京(ながおかきょう)\n3.藤原京(ふじわらきょう)\t4.恭仁京(くにきょう)", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+36)] = new Mathques1(list.get(r+36),"江戸時代、天理教をはじめた人物は？\n\n1.黒住宗忠(くろずみむねただ)\t2.川手文治郎(かわてぶんじろう)\n3.中山みき(なかやまみき)\t4.後藤象二郎(ごとうしょうじろう)", new String[]{"(1)", "(2)", "(3)", "(4)"}, 2);
        quizzes[list.get(r+37)] = new Mathques1(list.get(r+37),"室町幕府３代将軍に、11歳で就任した「足利義満」が幼少の頃、管領として将軍をもり立てた人物は？\n\n1.細川頼之(ほそかわよりゆき)\t2.斯波義廉(しばよしかど)\n3.上杉憲実(うえすぎのりざね)\t4.畠山政長(はたけやままさなが)", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+38)] = new Mathques1(list.get(r+38),"鎌倉時代、迅速な裁判をめざし、御家人たちの領地に関する訴訟を専門に担当させるために「引付衆」を設置した執権は？\\n\n1.北条泰時(ほうじょうやすとき)\t2.北条時宗(ほうじょうときむね)\t \n3.北条実時(ほうじょうさねとき)\t \t4.北条時頼(ほうじょうときより)", new String[]{"(1)", "(2)", "(3)", "(4)"}, 3);
        quizzes[list.get(r+39)] = new Mathques1(list.get(r+39),"鎌倉時代、「霜月騒動」で、滅ぼされた有力御家人は？\n\n1.安達泰盛(あだちやすもり)\t2.三浦泰村(みうらやすむら)\n3.和田義盛(わだよしもり)\t4.藤原泰衡(ふじわらのやすひら)", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+40)] = new Mathques1(list.get(r+40),"スイスやドイツに留学し、たんぱく質を研究、1910年にオリザニンの抽出に成功した化学者は？\n\n1.高峰譲吉(たかみねじょうきち)\t2.鈴木梅太郎(すずきうめたろう)\n3.北里柴三郎(きたざとしばさぶろう)\t4.志賀潔(しがきよし)", new String[]{"(1)", "(2)", "(3)", "(4)"}, 1);
        quizzes[list.get(r+41)] = new Mathques1(list.get(r+41),"超国家主義的な国家改造を主張し、右翼や青年将校に大きな影響を与え、「二・二六事件」の首謀者として銃殺された人物は？\n\n1.北一輝(きたいっき)\t2.井上日召(いのうえにっしょう)\n3.石原莞爾(いしはらかんじ)\t　\t4.大川周明(おおかわしゅうめい)", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+42)] = new Mathques1(list.get(r+42),"江戸時代、「富嶽三十六景」を描いた浮世絵師は？\t　\n\n1.歌川広重(うたがわひろしげ)　　\t2.喜多川歌麿(きたがわうたまろ)\n3.葛飾北斎(かつしかほくさい)\t4.東洲斎写楽(とうしゅうさいしゃらく)", new String[]{"(1)", "(2)", "(3)", "(4)"}, 2);
        quizzes[list.get(r+43)] = new Mathques1(list.get(r+43),"縄文中期の大遺跡「三内丸山遺跡」がある都道府県は？\n\n1.青森県\t2.群馬県\n3.静岡県\t4.佐賀県", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+44)] = new Mathques1(list.get(r+44),"平成元年に導入された消費税を実施したときの内閣総理大臣は？\n\n1.鈴木善幸(すずきぜんこう)\t2.中曽根康弘(なかそねやすひろ)\n3.竹下登(たけしたのぼる)\t4.宮沢喜一(みやざわきいち)", new String[]{"(1)", "(2)", "(3)", "(4)"}, 2);
        quizzes[list.get(r+45)] = new Mathques1(list.get(r+45),"最初の勅撰和歌集(ちょくせんわかしゅう)である「古今和歌集」の編纂を命じた天皇は？\n\n1.白河天皇(しらかわてんのう)\t2.聖武天皇(しょうむてんのう)\n3.醍醐天皇(だいごてんのう)\t4.村上天皇(むらかみてんのう)", new String[]{"(1)", "(2)", "(3)", "(4)"}, 2);
        quizzes[list.get(r+46)] = new Mathques1(list.get(r+46),"1949年、国鉄の総裁が、常磐線綾瀬(あやせ)駅付近の線路上で轢死体となって発見された事件を何という？\n\n1.三鷹事件(みたかじけん)\t2.下山事件(しもやまじけん)\n3.松川事件(まつかわじけん)\t4.大津事件(おおつじけん)", new String[]{"(1)", "(2)", "(3)", "(4)"}, 1);
        quizzes[list.get(r+47)] = new Mathques1(list.get(r+47),"桶狭間の戦いで、今川義元の首を取ったといわれる武将は？\n\n1.前田利家(まえだとしいえ)\t2.蒲生氏郷(がもううじさと)\n3.福島正則(ふくしままさのり)\t4.毛利新介(もうりしんすけ)", new String[]{"(1)", "(2)", "(3)", "(4)"}, 3);
        quizzes[list.get(r+48)] = new Mathques1(list.get(r+48),"剣豪「宮本武蔵」が書いた兵法の極意書は？\n\n1.五輪書(ごりんのしょ)\t2.葉隠(はがくれ)\n3.禁秘抄(きんぴしょう)\t4.梅松論(ばいしょうろん)", new String[]{"(1)", "(2)", "(3)", "(4)"}, 0);
        quizzes[list.get(r+49)] = new Mathques1(list.get(r+49),"江戸時代、７歳で失明したのにもかかわらず、和学講談所を設立し、古今の歴史書をテーマ別に分類した「群書類従」を著した人物は？\n\n1.頼山陽(らいさんよう)\t2.塙保己一(はなわほきいち)\n3.大槻玄沢(おおつきげんたく)\t4.平田篤胤(ひらたあつたね)", new String[]{"(1)", "(2)", "(3)", "(4)"}, 1);

    }

    // 問題取得
    public static Mathques1 getQuiz(int num) {
        if (num >= quizzes.length) {
            return null;
        }
        return quizzes[num];
    }
}
