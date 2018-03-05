function openWorkItemHistoryMain(urlString) {
    var w = screen.width * 0.8;
    var h = screen.height * 0.8;
    var left = (screen.width / 2) - (w / 2);
    var top = (screen.height / 2) - (h / 2);
    window
            .open(urlString,
                    'History',
                    'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width='
                    + w
                    + ', height='
                    + h
                    + ', top='
                    + top
                    + ', left='
                    + left).focus();
}

function openWorkItemHistoryWithContext(workItemId, contextPath) {
    var ulrString = contextPath + 'viewWorkItemHistory.jsf?workItemId=' + workItemId
    openWorkItemHistoryMain(ulrString);
}

function openWorkItemHistory(args, workItemId) {
    openWorkItemHistoryWithContext(workItemId, '');
}

function openWorkItemSearch(xhr, status, args) {
    var w = screen.width * 0.8;
    var h = screen.height * 0.8;
    var left = (screen.width / 2) - (w / 2);
    var top = (screen.height / 2) - (h / 2);
    window
            .open(
                    'dialogues/dialogueWorkItemSearch.jsf',
                    'Search',
                    'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, '
                    + 'copyhistory=no, width='
                    + w
                    + ', height='
                    + h
                    + ', top=' + top + ', left=' + left).focus();
}
function openWorkItemSearchMain(urlString) {
    var w = screen.width * 0.8;
    var h = screen.height * 0.8;
    var left = (screen.width / 2) - (w / 2);
    var top = (screen.height / 2) - (h / 2);
    window
            .open(urlString,
                    'Search',
                    'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, '
                    + 'copyhistory=no, width='
                    + w
                    + ', height='
                    + h
                    + ', top=' + top + ', left=' + left).focus();
}

function openDocumentSearch(xhr, status, args) {
    var w = screen.width * 0.8;
    var h = screen.height * 0.8;
    var left = (screen.width / 2) - (w / 2);
    var top = (screen.height / 2) - (h / 2);
    window
            .open(
                    '../dialogues/dialogueDocumentSearch.jsf',
                    'Document Search',
                    'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, '
                    + 'copyhistory=no, width='
                    + w
                    + ', height='
                    + h
                    + ', top=' + top + ', left=' + left).focus();
}

function openWorkItemSearchWithContext(contextPath) {
    var urlString = contextPath + 'dialogues/dialogueWorkItemSearch.jsf';
    openWorkItemSearchMain(urlString);
}
function openCaseDialogue(xhr, status, args) {
    var w = screen.width * 0.8;
    var h = screen.height * 0.8;
    var left = (screen.width / 2) - (w / 2);
    var top = (screen.height / 2) - (h / 2);
    window
            .open(
                    '../dialogues/dialogueWorkItemCase.jsf',
                    'Case Explore',
                    'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, '
                    + 'copyhistory=no, width='
                    + w
                    + ', height='
                    + h
                    + ', top=' + top + ', left=' + left).focus();
}

function openQueueCaseDialogue(xhr, status, args) {
    var w = screen.width * 0.8;
    var h = screen.height * 0.8;
    var left = (screen.width / 2) - (w / 2);
    var top = (screen.height / 2) - (h / 2);
    window
            .open(
                    'dialogues/dialogueWorkItemCase.jsf',
                    'Case Explore',
                    'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, '
                    + 'copyhistory=no, width='
                    + w
                    + ', height='
                    + h
                    + ', top=' + top + ', left=' + left).focus();
}

function openUserHistory(userName) {

    var w = screen.width * 0.6;
    var h = screen.height * 0.5;
    var left = (screen.width / 2) - (w / 2);
    var top = (screen.height / 2) - (h / 2);
    window
            .open(
                    'userHistory.jsf?userId=' + userName,
                    'User History',
                    'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width='
                    + w
                    + ', height='
                    + h
                    + ', top='
                    + top
                    + ', left='
                    + left).focus();

}

function handledlgUserManagementDetails(xhr, status, args) {
    if (args.validationFailed) {
        jQuery('#dlgUserManagementDetails').effect("shake", {
            times: 3
        }, 100);
    } else {
        PF('dlgUserManagementDetails').hide();
        PF('dataTable').filter();
    }
}

function handleFileProcessDialog(xhr, status, args) {
    if (args.validationFailed) {
        jQuery('#dlgFileProcess').effect("shake", {
            times: 3
        }, 100);
    } else {
        PF('dlgFileProcess').hide();
//                           dataTable.filter();
    }
}

function openNoteDialogue(xhr, status, args) {
    if (!args.validationFailed) {
        PF('dlgWorkItemNoteWidget').show()
    }
}


function handleUndiariseReturn(xhr, status, args) {
    if (!args.validationFailed) {
        PF('undiariseDialogue').show();
    }
}
