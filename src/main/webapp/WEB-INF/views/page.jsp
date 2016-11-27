<ul class="pagination" id="page">
    <input type="hidden" value="${blogPageWrap.currentPage}" id="currentPage"/>
    <input type="hidden" value="${blogPageWrap.totalPages}" id="totalPage"/>
    <li>
        <a onclick="prePage()">&laquo;</a>
    </li>
    <c:if test="${blogPageWrap.totalPages <= 5}">
        <c:forEach var="p" begin="1" end="${blogPageWrap.totalPages}">
            <li>
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
</ul>


