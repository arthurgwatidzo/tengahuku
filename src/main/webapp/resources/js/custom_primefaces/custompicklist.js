PrimeFaces.widget.CustomPickList = PrimeFaces.widget.BaseWidget.extend({
    init: function(a) {
        this._super(a);
        this.sourceList = this.jq.find("ul.ui-picklist-source");
        this.targetList = this.jq.find("ul.ui-picklist-target");
        this.sourceInput = $(this.jqId + "_source");
        this.targetInput = $(this.jqId + "_target");
        this.items = this.jq.find(".ui-picklist-item:not(.ui-state-disabled)");
        if (this.cfg.showCheckbox) {
            this.checkboxes = this.items.find("div.ui-chkbox > div.ui-chkbox-box")
        }
        this.generateItems(this.sourceList, this.sourceInput);
        this.generateItems(this.targetList, this.targetInput);
        if (this.cfg.disabled) {
            $(this.jqId + " li.ui-picklist-item").addClass("ui-state-disabled");
            $(this.jqId + " button").attr("disabled", "disabled").addClass("ui-state-disabled")
        } else {
            var b = this;
            $(this.jqId + " ul").sortable({
                cancel: ".ui-state-disabled,.ui-chkbox-box",
                connectWith: this.jqId + " .ui-picklist-list",
                revert: 1,
                update: function(c, d) {
                    b.unselectItem(d.item);
                    b.saveState()
                },
                receive: function(c, d) {
                    b.fireTransferEvent(d.item, d.sender, d.item.parents("ul.ui-picklist-list:first"), "dragdrop")
                },
                start: function(c, d) {
                    b.dragging = true
                },
                stop: function(c, d) {
                    b.dragging = false
                }
            });
            this.bindItemEvents();
            this.bindButtonEvents();
            this.bindFilterEvents()
        }
    },
    bindItemEvents: function() {
        var a = this;
        this.items.on("mouseover.pickList", function(c) {
            var b = $(this);
            if (!b.hasClass("ui-state-highlight")) {
                $(this).addClass("ui-state-hover")
            }
        }).on("mouseout.pickList", function(b) {
                $(this).removeClass("ui-state-hover")
            }).on("click.pickList", function(d) {
                if (a.checkboxClick || a.dragging) {
                    a.checkboxClick = false;
                    return
                }
                var k = $(this),
                    f = (d.metaKey || d.ctrlKey);
                if (!d.shiftKey) {
                    if (!f) {
                        a.unselectAll()
                    }
                    if (f && k.hasClass("ui-state-highlight")) {
                        a.unselectItem(k)
                    } else {
                        a.selectItem(k);
                        a.cursorItem = k
                    }
                } else {
                    a.unselectAll();
                    if (a.cursorItem && (a.cursorItem.parent().is(k.parent()))) {
                        var g = k.index(),
                            l = a.cursorItem.index(),
                            j = (g > l) ? l : g,
                            c = (g > l) ? (g + 1) : (l + 1),
                            h = k.parent();
                        for (var b = j; b < c; b++) {
                            a.selectItem(h.children("li.ui-picklist-item").eq(b))
                        }
                    } else {
                        a.selectItem(k);
                        a.cursorItem = k
                    }
                }
            }).on("dblclick.pickList", function() {
                var b = $(this);
                if ($(this).parent().hasClass("ui-picklist-source")) {
                    a.transfer(b, a.sourceList, a.targetList, "dblclick")
                } else {
                    a.transfer(b, a.targetList, a.sourceList, "dblclick")
                }
                PrimeFaces.clearSelection()
            });
        if (this.cfg.showCheckbox) {
            this.checkboxes.on("mouseover.pickList", function(c) {
                var b = $(this);
                if (!b.hasClass("ui-state-active")) {
                    b.addClass("ui-state-hover")
                }
            }).on("mouseout.pickList", function(b) {
                    $(this).removeClass("ui-state-hover")
                }).on("click.pickList", function(c) {
                    a.checkboxClick = true;
                    var b = $(this).closest("li.ui-picklist-item");
                    if (b.hasClass("ui-state-highlight")) {
                        a.unselectItem(b)
                    } else {
                        a.selectItem(b)
                    }
                })
        }
    },
    selectItem: function(a) {
        a.removeClass("ui-state-hover").addClass("ui-state-highlight");
        if (this.cfg.showCheckbox) {
            this.selectCheckbox(a.find("div.ui-chkbox-box"))
        }
    },
    unselectItem: function(a) {
        a.removeClass("ui-state-hover ui-state-highlight");
        if (this.cfg.showCheckbox) {
            this.unselectCheckbox(a.find("div.ui-chkbox-box"))
        }
    },
    unselectAll: function() {
        var b = this.items.filter(".ui-state-highlight");
        for (var a = 0; a < b.length; a++) {
            this.unselectItem(b.eq(a))
        }
    },
    selectCheckbox: function(a) {
        a.removeClass("ui-state-hover").addClass("ui-state-active").children("span.ui-chkbox-icon").addClass("ui-icon ui-icon-check")
    },
    unselectCheckbox: function(a) {
        a.removeClass("ui-state-active").children("span.ui-chkbox-icon").removeClass("ui-icon ui-icon-check")
    },
    generateItems: function(b, a) {
        b.children(".ui-picklist-item").each(function() {
            var e = $(this),
                f = PrimeFaces.escapeHTML(e.attr("data-item-value")),
                d = e.attr("data-item-label"),
                c = (d) ? PrimeFaces.escapeHTML(d) : "";
            a.append('<option value="' + f + '" selected="selected">' + c + "</option>")
        })
    },
    bindButtonEvents: function() {
        var a = this;
        PrimeFaces.skinButton(this.jq.find(".ui-button"));
        $(this.jqId + " .ui-picklist-button-add").click(function() {
            a.add()
        });
        $(this.jqId + " .ui-picklist-button-add-all").click(function() {
            a.addAll()
        });
        $(this.jqId + " .ui-picklist-button-remove").click(function() {
            a.remove()
        });
        $(this.jqId + " .ui-picklist-button-remove-all").click(function() {
            a.removeAll()
        });
        if (this.cfg.showSourceControls) {
            $(this.jqId + " td.ui-picklist-source-controls .ui-picklist-button-move-up").click(function() {
                a.moveUp(a.sourceList)
            });
            $(this.jqId + " td.ui-picklist-source-controls .ui-picklist-button-move-top").click(function() {
                a.moveTop(a.sourceList)
            });
            $(this.jqId + " td.ui-picklist-source-controls .ui-picklist-button-move-down").click(function() {
                a.moveDown(a.sourceList)
            });
            $(this.jqId + " td.ui-picklist-source-controls .ui-picklist-button-move-bottom").click(function() {
                a.moveBottom(a.sourceList)
            })
            $(this.jqId + " td.ui-picklist-source-controls .ui-picklist-button-preview").click(function() {
                a.firePreviewEvent(a.sourceList)
            })
            $(this.jqId + " td.ui-picklist-source-controls .ui-picklist-button-rotate-original").click(function() {
                a.fireCustomEvent(a.sourceList,'rotate-original')
            })
            $(this.jqId + " td.ui-picklist-source-controls .ui-picklist-button-rotate-left").click(function() {
                a.fireCustomEvent(a.sourceList,'rotate-left')
            })
            $(this.jqId + " td.ui-picklist-source-controls .ui-picklist-button-rotate-right").click(function() {
                a.fireCustomEvent(a.sourceList,'rotate-right')
            })
            $(this.jqId + " td.ui-picklist-source-controls .ui-picklist-button-rotate-flip").click(function() {
                a.fireCustomEvent(a.sourceList,'rotate-flip')
            })
        }
        if (this.cfg.showTargetControls) {
            $(this.jqId + " td.ui-picklist-target-controls .ui-picklist-button-move-up").click(function() {
                a.moveUp(a.targetList)
            });
            $(this.jqId + " td.ui-picklist-target-controls .ui-picklist-button-move-top").click(function() {
                a.moveTop(a.targetList)
            });
            $(this.jqId + " td.ui-picklist-target-controls .ui-picklist-button-move-down").click(function() {
                a.moveDown(a.targetList)
            });
            $(this.jqId + " td.ui-picklist-target-controls .ui-picklist-button-move-bottom").click(function() {
                a.moveBottom(a.targetList)
            })
            $(this.jqId + " td.ui-picklist-target-controls .ui-picklist-button-preview").click(function() {
                a.firePreviewEvent(a.targetList)
            })
            $(this.jqId + " td.ui-picklist-target-controls .ui-picklist-button-rotate-original").click(function() {
                a.fireCustomEvent(a.targetList,'rotate-original')
            })
            $(this.jqId + " td.ui-picklist-target-controls .ui-picklist-button-rotate-left").click(function() {
                a.fireCustomEvent(a.targetList,'rotate-left')
            })
            $(this.jqId + " td.ui-picklist-target-controls .ui-picklist-button-rotate-right").click(function() {
                a.fireCustomEvent(a.targetList,'rotate-right')
            })
            $(this.jqId + " td.ui-picklist-target-controls .ui-picklist-button-rotate-flip").click(function() {
                a.fireCustomEvent(a.targetList,'rotate-flip')
            })
        }
    },
    bindFilterEvents: function() {
        this.setupFilterMatcher();
        this.sourceFilter = $(this.jqId + "_source_filter");
        this.targetFilter = $(this.jqId + "_target_filter");
        var a = this;
        PrimeFaces.skinInput(this.sourceFilter);
        PrimeFaces.skinInput(this.targetFilter);
        this.sourceFilter.on("keyup", function(b) {
            a.filter(this.value, a.sourceList)
        });
        this.targetFilter.on("keyup", function(b) {
            a.filter(this.value, a.targetList)
        })
    },
    setupFilterMatcher: function() {
        this.cfg.filterMatchMode = this.cfg.filterMatchMode || "startsWith";
        this.filterMatchers = {
            startsWith: this.startsWithFilter,
            contains: this.containsFilter,
            endsWith: this.endsWithFilter,
            custom: this.cfg.filterFunction
        };
        this.filterMatcher = this.filterMatchers[this.cfg.filterMatchMode]
    },
    filter: function(f, e) {
        var g = $.trim(f).toLowerCase(),
            a = e.children("li.ui-picklist-item");
        if (g === "") {
            a.filter(":hidden").show()
        } else {
            for (var b = 0; b < a.length; b++) {
                var d = a.eq(b),
                    c = d.attr("data-item-label");
                if (this.filterMatcher(c, g)) {
                    d.fadeIn("fast")
                } else {
                    d.fadeOut("fast")
                }
            }
        }
    },
    startsWithFilter: function(b, a) {
        return b.toLowerCase().indexOf(a) === 0
    },
    containsFilter: function(b, a) {
        return b.toLowerCase().indexOf(a) !== -1
    },
    endsWithFilter: function(b, a) {
        return b.indexOf(a, b.length - a.length) !== -1
    },
    add: function() {
        var a = this.sourceList.children("li.ui-picklist-item.ui-state-highlight");
        this.transfer(a, this.sourceList, this.targetList, "command")
    },
    addAll: function() {
        var a = this.sourceList.children("li.ui-picklist-item:visible:not(.ui-state-disabled)");
        this.transfer(a, this.sourceList, this.targetList, "command")
    },
    remove: function() {
        var a = this.targetList.children("li.ui-picklist-item.ui-state-highlight");
        this.transfer(a, this.targetList, this.sourceList, "command")
    },
    removeAll: function() {
        var a = this.targetList.children("li.ui-picklist-item:visible:not(.ui-state-disabled)");
        this.transfer(a, this.targetList, this.sourceList, "command")
    },
    moveUp: function(f) {
        var b = this,
            e = b.isAnimated(),
            c = f.children(".ui-state-highlight"),
            a = c.length,
            d = 0;
        c.each(function() {
            var g = $(this);
            if (!g.is(":first-child")) {
                if (e) {
                    g.hide(b.cfg.effect, {}, b.cfg.effectSpeed, function() {
                        g.insertBefore(g.prev()).show(b.cfg.effect, {}, b.cfg.effectSpeed, function() {
                            d++;
                            if (d === a) {
                                b.saveState()
                            }
                        })
                    })
                } else {
                    g.hide().insertBefore(g.prev()).show()
                }
            }
        });
        if (!e) {
            this.saveState()
        }
    },
    moveTop: function(f) {
        var b = this,
            e = b.isAnimated(),
            c = f.children(".ui-state-highlight"),
            a = c.length,
            d = 0;
        f.children(".ui-state-highlight").each(function() {
            var g = $(this);
            if (!g.is(":first-child")) {
                if (e) {
                    g.hide(b.cfg.effect, {}, b.cfg.effectSpeed, function() {
                        g.prependTo(g.parent()).show(b.cfg.effect, {}, b.cfg.effectSpeed, function() {
                            d++;
                            if (d === a) {
                                b.saveState()
                            }
                        })
                    })
                } else {
                    g.hide().prependTo(g.parent()).show()
                }
            }
        });
        if (!e) {
            this.saveState()
        }
    },
    moveDown: function(f) {
        var b = this,
            e = b.isAnimated(),
            c = f.children(".ui-state-highlight"),
            a = c.length,
            d = 0;
        $(f.children(".ui-state-highlight").get().reverse()).each(function() {
            var g = $(this);
            if (!g.is(":last-child")) {
                if (e) {
                    g.hide(b.cfg.effect, {}, b.cfg.effectSpeed, function() {
                        g.insertAfter(g.next()).show(b.cfg.effect, {}, b.cfg.effectSpeed, function() {
                            d++;
                            if (d === a) {
                                b.saveState()
                            }
                        })
                    })
                } else {
                    g.hide().insertAfter(g.next()).show()
                }
            }
        });
        if (!e) {
            this.saveState()
        }
    },
    moveBottom: function(f) {
        var b = this,
            e = b.isAnimated(),
            c = f.children(".ui-state-highlight"),
            a = c.length,
            d = 0;
        f.children(".ui-state-highlight").each(function() {
            var g = $(this);
            if (!g.is(":last-child")) {
                if (e) {
                    g.hide(b.cfg.effect, {}, b.cfg.effectSpeed, function() {
                        g.appendTo(g.parent()).show(b.cfg.effect, {}, b.cfg.effectSpeed, function() {
                            d++;
                            if (d === a) {
                                b.saveState()
                            }
                        })
                    })
                } else {
                    g.hide().appendTo(g.parent()).show()
                }
            }
        });
        if (!e) {
            this.saveState()
        }
    },
    fireCustomEvent: function(f,customeventtype) {
        if (this.cfg.behaviors) {
            var a = this.cfg.behaviors.customevent;
            if (a) {
                var b = {
                        params: []
                    },
                    d = this.id + "_custom";
                var e = f.children(".ui-state-highlight");
               /* if (e.length == 0){
                    e = f.children();
                }*/
                e.each(function(j, k) {
                    b.params.push({
                        name: d,
                        value: $(k).attr("data-item-value")
                    })
                });

                b.params.push({
                    name: this.id + "_customeventtype",
                    value: customeventtype
                });
                a.call(this, null, b)
            }
        }
    },
    firePreviewEvent: function(f) {
        if (this.cfg.behaviors) {
            var a = this.cfg.behaviors.preview;
            if (a) {
                var b = {
                        params: []
                    },
                    d = this.id + "_previewed";
                var e = f.children(".ui-state-highlight");
                if (e.length == 0){
                    e = f.children();
                }
                e.each(function(j, k) {
                    b.params.push({
                        name: d,
                        value: $(k).attr("data-item-value")
                    })
                });

                a.call(this, null, b)
            }
        }
    },
    saveState: function() {
        this.sourceInput.children().remove();
        this.targetInput.children().remove();
        this.generateItems(this.sourceList, this.sourceInput);
        this.generateItems(this.targetList, this.targetInput);
        this.cursorItem = null
    },
    transfer: function(b, g, f, d) {
        var e = this,
            a = b.length,
            c = 0;
        if (this.isAnimated()) {
            b.hide(this.cfg.effect, {}, this.cfg.effectSpeed, function() {
                var h = $(this);
                e.unselectItem(h);
                h.appendTo(f).show(e.cfg.effect, {}, e.cfg.effectSpeed, function() {
                    c++;
                    if (c == a) {
                        e.saveState();
                        e.fireTransferEvent(b, g, f, d)
                    }
                })
            })
        } else {
            b.hide();
            if (this.cfg.showCheckbox) {
                b.each(function() {
                    e.unselectItem($(this))
                })
            }
            b.appendTo(f).show();
            this.saveState();
            this.fireTransferEvent(b, g, f, d)
        }
    },
    fireTransferEvent: function(e, g, h, f) {
        if (this.cfg.onTransfer) {
            var c = {};
            c.items = e;
            c.from = g;
            c.to = h;
            c.type = f;
            this.cfg.onTransfer.call(this, c)
        }
        if (this.cfg.behaviors) {
            var a = this.cfg.behaviors.transfer;
            if (a) {
                var b = {
                        params: []
                    },
                    d = this.id + "_transferred",
                    i = g.hasClass("ui-picklist-source");
                e.each(function(j, k) {
                    b.params.push({
                        name: d,
                        value: $(k).attr("data-item-value")
                    })
                });
                b.params.push({
                    name: this.id + "_add",
                    value: i
                });
                a.call(this, null, b)
            }
        }
    },
    isAnimated: function() {
        return (this.cfg.effect && this.cfg.effect != "none")
    }
});