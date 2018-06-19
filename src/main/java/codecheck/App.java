package codecheck;

public class App {
	public static void main(String[] args) {

		if (args == null) {
			System.out.println("Error!");
		} else {
			//今回は処理を繰り返す
			for (int i = 0, l = args.length; i < l; i++) {
				if (args[i] != null) {
					int target;

					//結果格納変数　初期値はその他invalid
					//それ以外の入力の場合、invalid
					String resultString = "invalid";

					boolean idiot = false;
					boolean stupid = false;
					boolean numErr = false;
					//引数を変換 文字だったりした場合はExecption
					try {
						//TODO:int超える場合の考慮(MAX:2147483647)

						//数字判定
						//先頭のプラスマイナス記号だけ削除して判定
						String numChekStr;
						if (args[i].startsWith("+")) {
							numChekStr = args[i].substring(1);
						} else if (args[i].startsWith("+")) {
							numChekStr = args[i].substring(1);
						} else {
							numChekStr = args[i];
						}

						for (int k = 0; k < numChekStr.length(); k++) {
							try {
								target = Integer.parseInt(args[i]);
							} catch (NumberFormatException e) {
								//数字以外有
								numErr = true;
								break;
							}
						}

						//数字以外の場合はエラーログを出力して次の変数へ
						if (numErr) {
							System.out.println("数字ではありません。");
							continue;
						}

						try {
							target = Integer.parseInt(args[i]);
						}catch (Exception e) {
							//ここでエラーが出るということは桁あふれ
							//1000以上もしくは0未満確定なのでinvalid扱い
							System.out.println(resultString);
							continue;
						}


						// 1000以下の非負整数
						if (target <= 1000 & target > 0) {
							if (target / 3 == 0) {
								//3の倍数の1000以下の非負整数の場合、 idiot
								idiot = true;
							}
							//文字列変換して3が含まれていないか探す
							if (Integer.toString(target).indexOf("3") != -1) {
								//3のつく1000以下の非負整数の場合、 stupid
								stupid = true;
							}
							if (idiot && stupid) {
								//3の倍数でかつ3のつく1000以下の非負整数の場合、
								//idiotとstupidではなく、 dumb
								resultString = "dumb";
							} else if (idiot) {
								resultString = "idiot";
							} else if (stupid) {

								resultString = "stupid";
							} else {
								//それ以外の1000以下の非負整数の場合、smart
								resultString = "smart";
							}
						}
						//結果出力
						System.out.println(resultString);

					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		}
	}
}
