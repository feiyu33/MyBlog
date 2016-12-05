<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<ul class="pagination" id="page">
    <input type="hidden" value="${blogPageWrap.totalPages}" id="totalPage"/>
    <li>
        <a onclick="prePage()">&laquo;</a>
    </li>
    <c:if test="${blogPageWrap.totalPages <= 5}">
        <c:forEach var="p" begin="1" end="${blogPageWrap.totalPages}">
            <li <c:if test="${blogPageWrap.currentPage == p}">style="color:red;" </c:if>>
                <a>${p}</a>
            </li>
        </c:forEach>
    </c:if>
    <c:if test="${blogPageWrap.totalPages > 5}">
        <li>
            <a>1</a>
            <a>2</a>
            <a>...</a>
            <a>${blogPageWrap.totalPages-1}</a>
            <a>${blogPageWrap.totalPages}</a>
        </li>
    </c:if>
    <li>
        <a onclick="nextPage()">&raquo;</a>
    </li>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="hidden" value="${blogPageWrap.currentPage}" id="pages"/>
    <input type="text" value="${blogPageWrap.currentPage}" id="currentPage" size="1"/> / ${blogPageWrap.totalPages}
    <button onclick="turnByPage()" type="button" class="btn btn-primary btn-xs">go</button>
</ul>


