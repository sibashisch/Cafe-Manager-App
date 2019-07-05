TableView = function () {
	this.divId = null;
	this.message = null;
	this.overley = null;
	
	this.create = function (id, msg, ovrl) {
		this.divId = id;
		this.message = msg;
		this.overley = ovrl;
	}
	
	this.refreshTables = function (obj) {
		this.message.showMessage ('Data Loading', 'alert alert-info');
		
		$.ajax ({
			url: '../gettables',
			dataType: 'json',
			method: 'get',
			success: function (json) {
				if (json && json.STATUS && json.STATUS === 'SUCCESS') {
					obj.render (json.TABLES, obj);
					obj.message.hide();
				} else {
					console.log (this);
					obj.message.showMessage ('Error: Could not load data.<br />' + (json.ERROR?json.ERROR:''), 'alert alert-danger');
				}
			},
			error: function (jqXHR, exception) {
				try {
					console.log (jqXHR);
					console.log (exception);
				} catch (err) {}
				
				obj.message.showMessage ('Error: Could not load data.', 'alert alert-danger');
			}
		});
	}
	
	this.render = function (tables, obj) {
		let markup = '<div class="row tableContainerRow>';
		markup += '<div class="col-sm-12 tableContainerCell">';
		markup += '<div class="row tableRow">';
		let i = 0;
		while (i<tables.length) {
			markup += '<div class="col-sm-2 tableCell">';
			markup += '<div class="col-sm-12 tableCellInner"';
			markup += ' style="background-color: ' + tables[i].BG_COLOR + '; border-color: ' + tables[i].BG_COLOR + '"';
			markup += ' data-id = "' + tables[i].TABLE_ID + '"';
			markup += ' data-next = "' + tables[i].NEXT_STATE_DESC + '"';
			markup += '>';
			markup += '<span class="tableNo">' + tables[i].TABLE_ID + '</span><br />';
			markup += tables[i].CURR_STATE_DESC;
			markup += '</div></div>';
			if (i % 6 == 5) {
				markup += '</div><div class="row tableRow">';
			}
			i ++;
		}
		markup += '</div></div></div>';
		$('#'+this.divId).append(markup);
		
		$(".tableCellInner").click (function () {
			var tableNo = $(this).attr ('data-id');
			var nextState = $(this).attr ('data-next');
			if (confirm ('Marking Table #' + tableNo + ' as:\n' + nextState)) {
				obj.message.showMessage ('Updating table state. Please wait.', 'alert alert-info');

				$.ajax({
					url: '../changestate/' + tableNo,
					method: 'post',
					dataType: 'json',
					success: function (json) {
						if (json && json.STATUS && json.STATUS === 'SUCCESS') {
							window.location.reload();
						} else {
							try {
								console.log (json);
							} catch (ignore) {}
							obj.message.showMessage ('Could not change table state. Please refresh this page.<br />' + (json.ERROR?json.ERROR:''), 'alert alert-danger');
						}
						
					},
					error: function (jqXHR, exception) {
						overleyElem.hide();
						obj.message.showMessage ('Could not change table state. Please refresh this page.');
						
						try {
							console.log (jqXHR);
							console.log (exception);
						} catch (ignore) {}
					}
				});
			};
		});
	}
}

MessageBoard = function () {
	this.messageElem = null;
	this.overley = null;
	
	this.create = function (ovrl) {
		this.overley = ovrl;
		
		this.messageElem = $('<div class="col-sm-offset-1 col-sm-10"></div>');
		this.messageElem.css ({"z-index": 10, "position": "absolute"});
		this.messageElem.hide();
		$('body').append (this.messageElem);
	}
	
	this.setPosition = function () {
		let thisHeight = this.messageElem.height();
		let docHeight = $(document).height();
		let topVal = ((docHeight - thisHeight) < 0) ? 0 : ((docHeight - thisHeight)/2);
		this.messageElem.css ({"top": topVal});
	}
	
	this.showMessage = function (txt, cls) {
		this.messageElem.html(txt);
		this.messageElem.removeClass('alert alert-success alert-warning alert-danger alert-primary alert-info');
		this.messageElem.addClass(cls);
		this.overley.show();
		this.messageElem.show();
		this.setPosition();
	}
	
	this.hide = function () {
		this.overley.hide();
		this.messageElem.hide();
	}
}

OverLay = function () {
	
	this.overleyElem = null;
	
	this.create = function () {
		this.overleyElem = $('<div></div>');
		this.overleyElem.css ({"background-color":"black", "opacity":".7", "top": 0, "left": 0, "position": "absolute", "z-index": 9});
		this.overleyElem.height ($(document).height());
		this.overleyElem.width ($(document).width());
		this.overleyElem.hide();
		$('body').append (this.overleyElem);
	}
	
	this.show = function () {
		this.overleyElem.show();
	}
	
	this.hide = function () {
		this.overleyElem.hide();
	}
}