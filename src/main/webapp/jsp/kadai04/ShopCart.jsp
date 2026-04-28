<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="scBean" scope="request" class="kadai04.ShopCartBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>課題４</title>
<script type="text/javascript">
<!--

/* ボタン押下時（追加ボタン、確定ボタン） */
function clickBtn(btnNm) {

	// 押下したボタン名を保存
	document.frm.clickBtnNm.value = btnNm;

	document.frm.submit();
}

/* ボタン押下時（＋ボタン、－ボタン） */
function clickBtnPlusMinus(btnNm, idx) {

	// 押下したボタン名を保存
	document.frm.clickBtnNm.value = btnNm;
	// 押下した行の、行番号を保存
	document.frm.clickBtnIdx.value = idx;

	document.frm.submit();
}
// -->
</script>
</head>
<body>

	<form name="frm" method="post" action="/KenshuWeb/kadai04">
		<input type="hidden" name="clickBtnNm" value="">
		<input type="hidden" name="clickBtnIdx" value="">
		<table border="1">
			<tr style="background: yellow;">
				<th width="120">品物</th>
				<th width="60">単価</th>
				<th width="60">数量</th>
				<th width="30">増</th>
				<th width="30">減</th>
			</tr>
		<%
			for(int i = 0; i < scBean.getLstItemNmCnt(); i++) {
		%>
			<tr>
				<td><%= scBean.getItemNmByRowNo(i) %></td>
				<td align="right"><%= scBean.getTankaByRowNo(i) %></td>
				<td align="right"><%= scBean.getSuryoByRowNo(i) %></td>
				<td align="center"><input type="button" value="＋" onClick="clickBtnPlusMinus('btnPlus',<%= i %>);"></td>
				<td align="center"><input type="button" value="－" onClick="clickBtnPlusMinus('btnMinus',<%= i %>);"></td>
			</tr>
		<%
			}
		%>
		</table>
		<br>
		<br>
		<table border="0">
			<tr>
				<td width="120"><input type="text" name="txtItemNm"  size="18"></td>
				<td width="60" align="right"> <input type="text" name="txtTanka" size="8"></td>
				<td width="60" align="right"> <input type="text" name="txtSuryo" size="8"></td>
				<td width="50" align="center"> <input type="button" value="追加" onClick="clickBtn('btnAdd');"></td>
				<td width="50" align="center"> <input type="button" value="確定" onClick="clickBtn('btnKakutei');"></td>
			</tr>
		</table>
	</form>

</body>
</html>