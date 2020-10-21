


function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn
						, detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
	// 팝업페이지에서 주소입력한 정보를 받아서, 변수에 저장한 다음 현재 페이지로 리턴 해줍니다.
	document.fr.roadAddrPart1.value = roadAddrPart1;
	document.fr.roadAddrPart2.value = roadAddrPart2;
	document.fr.addrDetail.value = addrDetail;
	document.fr.zipNo.value = zipNo;
}
